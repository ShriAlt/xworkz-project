package com.xworkz.techroute.service;

import com.xworkz.techroute.dto.ProductMasterDTO;
import com.xworkz.techroute.dto.PurchaseDto;
import com.xworkz.techroute.dto.StockDTO;
import com.xworkz.techroute.entity.*;
import com.xworkz.techroute.enums.CustomerType;
import com.xworkz.techroute.enums.IssueCode;
import com.xworkz.techroute.repository.AdminRepository;
import com.xworkz.techroute.repository.ProfileRepository;
import com.xworkz.techroute.repository.StockRepository;
import com.xworkz.techroute.repository.UserRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    private final ProfileRepository profileRepository;

    private  final AdminRepository adminRepository;

    private final TemplateEngine templateEngine;

    private final StockRepository stockRepository;

    public UserServiceImpl(UserRepository userRepository , ProfileRepository profileRepository, AdminRepository adminRepository ,StockRepository stockRepository, TemplateEngine templateEngine) {
        this.userRepository=userRepository;
        this.profileRepository = profileRepository;
        this.adminRepository=adminRepository;
        this.templateEngine=templateEngine;
        this.stockRepository=stockRepository;
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
        List<ProductMasterEntity> productMasterEntities =
                userRepository.fetchAllProductsByGroupName(productGroupName);

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
                                      stock.getLastUpdated(),
                                        stock.getWarehouse(),
                                        stock.getPurchasePrice(),
                                        stock.getOpeningValue(),
                                        stock.getQuantity(),
                                        stock.getStockId()
                                ))
                                .collect(Collectors.toList())
                ))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<StockDTO> fetchAllStock() {
        List<StockEntity> all = stockRepository.findAll();
        List<StockDTO> stockDTOs = new ArrayList<>();

        all.forEach(stockEntity -> {
            StockDTO stockDTO = new StockDTO();
            stockDTO.setStockId(stockEntity.getStockId());
            stockDTO.setWarehouse(stockEntity.getWarehouse());
            stockDTO.setLastUpdated(stockEntity.getLastUpdated());
            stockDTO.setOpeningValue(stockEntity.getOpeningValue());
            stockDTO.setQuantity(stockEntity.getQuantity());
            stockDTO.setPurchasePrice(stockEntity.getPurchasePrice());

            ProductMasterEntity product = stockEntity.getProduct();
            ProductMasterDTO productMasterDTO = new ProductMasterDTO();
            productMasterDTO.setProductId(product.getProductId());
            productMasterDTO.setProductCode(product.getProductCode());
            productMasterDTO.setProductName(product.getProductName());
            productMasterDTO.setProductGroupName(product.getProductGroupName());
            productMasterDTO.setModel(product.getModel());
            productMasterDTO.setCompanyName(product.getCompanyName());
            productMasterDTO.setVariantAttributes(product.getVariantAttributes());
            productMasterDTO.setDefaultPurchasePrice(product.getDefaultPurchasePrice());
            productMasterDTO.setDefaultSalePrice(product.getDefaultSalePrice());
            productMasterDTO.setStatus(product.getStatus());
            productMasterDTO.setCreatedAt(product.getCreatedAt());
            productMasterDTO.setUpdatedAt(product.getUpdatedAt());

            // Link productDTO back into stockDTO
            stockDTO.setProductMasterDTO(productMasterDTO);

            // Optionally: link stockDTO list back into productDTO
            productMasterDTO.setStocks(Collections.singletonList(stockDTO));

            // Add to result list
            stockDTOs.add(stockDTO);
        });

        return stockDTOs;
    }
}
