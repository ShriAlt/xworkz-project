package com.xworkz.techRoute.service;

import com.xworkz.techRoute.dto.PurchaseDto;
import com.xworkz.techRoute.entity.ProductGroupEntity;
import com.xworkz.techRoute.enums.IssueCode;
import com.xworkz.techRoute.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository=userRepository;
    }

    @Override
    public IssueCode validateAndSaveOrder(PurchaseDto dto) {

        return IssueCode.OK;
    }

    @Override
    public boolean validateAndAddGroupName(String productGroupName) {
        List<ProductGroupEntity> all = userRepository.findAll();
       for (ProductGroupEntity productGroupEntity : all){
           if (productGroupEntity.getProductGroupName().equals( productGroupName)){
               return false;
           }
       }
        ProductGroupEntity productGroupEntity = new ProductGroupEntity();
        productGroupEntity.setProductGroupName(productGroupName);
        return userRepository.save(productGroupEntity);
    }
}
