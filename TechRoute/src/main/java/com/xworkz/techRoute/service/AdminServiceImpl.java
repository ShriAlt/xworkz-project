package com.xworkz.techRoute.service;

import com.xworkz.techRoute.dto.CustomerDto;
import com.xworkz.techRoute.entity.CustomerEntity;
import com.xworkz.techRoute.enums.IssueCode;
import com.xworkz.techRoute.repository.ProfileRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService{
    public AdminServiceImpl(){
        System.out.println("no args of AdminServiceImpl");
    }

    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public IssueCode validateAndSaveCustomer(CustomerDto dto) {
        if (dto == null){
            return IssueCode.INVALID;
        }
        CustomerEntity customerEntity = new CustomerEntity();
        BeanUtils.copyProperties(dto,customerEntity);
        System.err.println(customerEntity+"in service");
        profileRepository.save(customerEntity);
        return IssueCode.OK;
    }
}
