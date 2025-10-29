package com.xworkz.techRoute.service;

import com.xworkz.techRoute.dto.CustomerDto;
import com.xworkz.techRoute.entity.CustomerEntity;
import com.xworkz.techRoute.enums.IssueCode;
import com.xworkz.techRoute.repository.AdminRepository;
import com.xworkz.techRoute.repository.ProfileRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService{
    public AdminServiceImpl(){
        System.out.println("no args of AdminServiceImpl");
    }

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public IssueCode validateAndSaveCustomer(CustomerDto dto) {
        if (dto == null){
            return IssueCode.INVALID;
        }
        if (adminRepository.fetchCustomerEntityByMail(dto.getEmail())!= null){
            return IssueCode.EMAIL_EXIST;
        }
        if (adminRepository.fetchCustomerEntityByNumber(dto.getContact())!= null){
            return IssueCode.PHONE_EXIST;
        }
        CustomerEntity customerEntity = new CustomerEntity();
        BeanUtils.copyProperties(dto,customerEntity);
    if (!profileRepository.save(customerEntity)){
            return IssueCode.DB_ERROR;
        }
        return IssueCode.OK;
    }
    @Override
    public List<CustomerDto> viewCustomer(){
      List <CustomerEntity> customerEntities = adminRepository.findAll();

      List<CustomerDto> customerDtosList = new ArrayList<>();
      for(CustomerEntity customerEntity : customerEntities){
          CustomerDto customerDto = new CustomerDto();
          BeanUtils.copyProperties(customerEntity,customerDto);
          customerDtosList.add(customerDto);
      }
        return customerDtosList;
    }
    @Override
    public IssueCode validateAndUpdate(CustomerDto dto) {
        if (dto == null){
            return IssueCode.INVALID;
        }
        CustomerEntity existingByEmail = adminRepository.fetchCustomerEntityByMail(dto.getEmail());
        if (existingByEmail != null && existingByEmail.getId() != dto.getId()) {
            return IssueCode.EMAIL_EXIST;
        }

        CustomerEntity existingByPhone = adminRepository.fetchCustomerEntityByNumber(dto.getContact());
        if (existingByPhone != null && existingByPhone.getId() != dto.getId()) {
            return IssueCode.PHONE_EXIST;
        }

        CustomerEntity customerEntity = new CustomerEntity();
        BeanUtils.copyProperties(dto,customerEntity);
        customerEntity.setId(dto.getId());
        if(!profileRepository.updateProfile(customerEntity)){
            return IssueCode.DB_ERROR;
        }
        return IssueCode.OK;
    }
    @Override
    public CustomerDto fetchCustomer(int id) {
        CustomerEntity customerEntity = adminRepository.fetchCustomerEntity(id);
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customerEntity,customerDto);
        return customerDto;
    }
    @Override
    public boolean deleteCustomer(int id) {
        return  adminRepository.deleteCustomer(id);
    }

    @Override
    public boolean checkCustomerEmail(String email) {
        if (email == null){
            return false;
        }
        CustomerEntity customerEntity = adminRepository.fetchCustomerEntityByMail(email);
        return customerEntity != null;
    }
    @Override
    public boolean checkCustomerPhone(String phone) {
        if (phone == null){
            return false;
        }
        CustomerEntity customerEntity = adminRepository.fetchCustomerEntityByNumber(phone);
        return customerEntity != null;
    }
}
