package com.xworkz.techroute.service;

import com.xworkz.techroute.dto.ProductMasterDTO;
import com.xworkz.techroute.dto.PurchaseDto;
import com.xworkz.techroute.dto.StockDTO;
import com.xworkz.techroute.entity.CustomerEntity;
import com.xworkz.techroute.entity.ProductGroupEntity;
import com.xworkz.techroute.entity.ProductMasterEntity;
import com.xworkz.techroute.entity.PurchaseEntity;
import com.xworkz.techroute.enums.CustomerType;
import com.xworkz.techroute.enums.IssueCode;
import com.xworkz.techroute.repository.AdminRepository;
import com.xworkz.techroute.repository.ProfileRepository;
import com.xworkz.techroute.repository.UserRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    private final ProfileRepository profileRepository;

    private  final AdminRepository adminRepository;

    private final TemplateEngine templateEngine;

    public UserServiceImpl(UserRepository userRepository , ProfileRepository profileRepository, AdminRepository adminRepository , TemplateEngine templateEngine) {
        this.userRepository=userRepository;
        this.profileRepository = profileRepository;
        this.adminRepository=adminRepository;
        this.templateEngine=templateEngine;
    }
    @Override
    public IssueCode validateAndSaveOrder(PurchaseDto dto) {
        CustomerEntity customerEntity = userRepository.findByCustomerName(dto.getCustomerName());

        if (!dto.getCustomerName().equals(customerEntity.getCustomerName())){
            return IssueCode.NAME_EXIST;
        }
        PurchaseEntity purchaseEntity = new PurchaseEntity();
        BeanUtils.copyProperties(dto,purchaseEntity);
        boolean save = profileRepository.save(purchaseEntity);
        if (!save){
            return IssueCode.INVALID;
        }
        return IssueCode.OK;
    }
    @Override
    public boolean validateAndAddGroupName(String productGroupName) {
        List<ProductGroupEntity> all = userRepository.findAllProductGroupName();
       for (ProductGroupEntity productGroupEntity : all){
           if (productGroupEntity.getProductGroupName().equals( productGroupName)){
               return false;
           }
       }
        ProductGroupEntity productGroupEntity = new ProductGroupEntity();
        productGroupEntity.setProductGroupName(productGroupName);
        return profileRepository.save(productGroupEntity);
    }
    @Override
    public List<String > fetchProducts() {
        return userRepository.findAllProductGroupName().stream().map(ProductGroupEntity::getProductGroupName).collect(Collectors.toList());
    }

    @Override
    public List<String> fetchDebitors() {
        return userRepository.findAllCustomer().stream().filter(customerEntity -> customerEntity.getCustomerType().equals(CustomerType.Debitors)).map(CustomerEntity::getCustomerName).collect(Collectors.toList());

    }
    @Override
    public List<String> fetchCreditors() {
        return userRepository.findAllCustomer().stream().filter(customerEntity -> customerEntity.getCustomerType().equals(CustomerType.Creditors)).map(CustomerEntity::getCustomerName).collect(Collectors.toList());
    }
    @Override
    public void saveOrders(List<PurchaseDto> dtoList) {
        for (PurchaseDto dto : dtoList){
            PurchaseEntity purchaseEntity = new PurchaseEntity();
            BeanUtils.copyProperties(dto,purchaseEntity);
            profileRepository.save(purchaseEntity);
        }
    }
    @Override
    public String generateInvoiceForDownload(String orderId) {
        PurchaseEntity order = adminRepository.findOrderById(Integer.parseInt(orderId));
        if (order==null){
            return "errorFindingOrder";
        }
        CustomerEntity customer = userRepository.findByCustomerName(order.getCustomerName());
        if (customer == null){
            return "errorFindingCustomer";
        }
        System.err.println(customer);
        Context context = new Context();
        context.setVariable("order", order);
        context.setVariable("customer", customer);
        return templateEngine.process("DebitorsInvoice", context);
    }

    @Override
    public List<ProductMasterDTO> fetchProductsByGroup(String productGroupName) {
        System.out.println("==================================== in service");

        List<ProductMasterEntity> productMasterEntities =
                userRepository.fetchAllProductsByGroupName(productGroupName);

        // Map entities to DTOs
        return productMasterEntities.stream()
                .map(entity -> new ProductMasterDTO(
                        entity.getProductId(),
                        entity.getProductCode(),
                        entity.getProductName(),
                        entity.getProductGroupName(),
                        entity.getModel(),
                        entity.getCompanyName(),
                        entity.getVariantAttributes(),
                        entity.getDefaultPurchasePrice(),
                        entity.getDefaultSalePrice(),
                        entity.getStatus(),
                        entity.getCreatedAt(),
                        entity.getUpdatedAt(),
                        entity.getStocks().stream()
                                .map(stock -> new StockDTO(
                                        stock.getStockId(),
                                        stock.getQuantity(),
                                        stock.getOpeningValue(),
                                        stock.getPurchasePrice(),
                                        stock.getWarehouse(),
                                        stock.getLastUpdated()
                                ))
                                .collect(Collectors.toList())
                ))
                .collect(Collectors.toList());
    }

}
