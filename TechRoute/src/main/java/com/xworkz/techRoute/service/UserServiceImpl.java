package com.xworkz.techRoute.service;

import com.xworkz.techRoute.dto.CustomerDto;
import com.xworkz.techRoute.dto.PurchaseDto;
import com.xworkz.techRoute.entity.CustomerEntity;
import com.xworkz.techRoute.entity.ProductGroupEntity;
import com.xworkz.techRoute.entity.PurchaseEntity;
import com.xworkz.techRoute.enums.CustomerType;
import com.xworkz.techRoute.enums.IssueCode;
import com.xworkz.techRoute.repository.ProfileRepository;
import com.xworkz.techRoute.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    private final ProfileRepository profileRepository;

    public UserServiceImpl(UserRepository userRepository , ProfileRepository profileRepository) {
        this.userRepository=userRepository;
        this.profileRepository = profileRepository;
    }

    @Override
    public IssueCode validateAndSaveOrder(PurchaseDto dto) {
        CustomerEntity customerEntity = userRepository.findByName(dto.getCustomerName());

        if (!dto.getCustomerName().equals(customerEntity.getCustomerName())){
            return IssueCode.NAME_EXIST;
        }
        PurchaseEntity purchaseEntity = new PurchaseEntity();
        BeanUtils.copyProperties(dto,purchaseEntity);
        System.err.println(purchaseEntity);
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
    public void saveCustomer(List<CustomerDto> dos) {
        for (CustomerDto dto : dos ){
            CustomerEntity customerEntity = new CustomerEntity();
            BeanUtils.copyProperties(dto,customerEntity);
            profileRepository.save(customerEntity);
        }
    }

    @Override
    public void saveOrders(List<PurchaseDto> dtoList) {
        for (PurchaseDto dto : dtoList){
            PurchaseEntity purchaseEntity = new PurchaseEntity();
            BeanUtils.copyProperties(dto,purchaseEntity);
            profileRepository.save(purchaseEntity);
        }
    }
}
