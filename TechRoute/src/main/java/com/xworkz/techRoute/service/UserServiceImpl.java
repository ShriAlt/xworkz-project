package com.xworkz.techRoute.service;

import com.xworkz.techRoute.dto.PurchaseDto;
import com.xworkz.techRoute.entity.CustomerEntity;
import com.xworkz.techRoute.entity.ProductGroupEntity;
import com.xworkz.techRoute.entity.PurchaseEntity;
import com.xworkz.techRoute.enums.CustomerType;
import com.xworkz.techRoute.enums.IssueCode;
import com.xworkz.techRoute.repository.AdminRepository;
import com.xworkz.techRoute.repository.ProfileRepository;
import com.xworkz.techRoute.repository.UserRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

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
}
