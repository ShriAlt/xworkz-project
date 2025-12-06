package com.xworkz.techRoute.service;

import com.xworkz.techRoute.dto.CustomerDto;
import com.xworkz.techRoute.dto.ProductMasterDTO;
import com.xworkz.techRoute.dto.PurchaseDto;
import com.xworkz.techRoute.entity.CustomerEntity;
import com.xworkz.techRoute.entity.ProductGroupEntity;
import com.xworkz.techRoute.entity.ProductMasterEntity;
import com.xworkz.techRoute.entity.PurchaseEntity;
import com.xworkz.techRoute.enums.IssueCode;
import com.xworkz.techRoute.enums.OrderStatus;
import com.xworkz.techRoute.repository.AdminRepository;
import com.xworkz.techRoute.repository.ProfileRepository;
import com.xworkz.techRoute.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
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

    @Autowired
    private UserRepository userRepository;

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
      List <CustomerEntity> customerEntities = adminRepository.findAllCustomer();

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

    @Override
    public List<PurchaseDto> getAllPendingOrders() {
        List<PurchaseEntity> allOrders = adminRepository.findAllOrders();
        if (allOrders.isEmpty()){
            return Collections.emptyList();
        }
        List<PurchaseDto> purchaseDtoList = new ArrayList<>();
        allOrders.stream().filter(purchaseEntity -> purchaseEntity.getOrderStatus().equals(OrderStatus.PENDING)).forEach(purchaseEntity ->{
            PurchaseDto purchaseDto = new PurchaseDto();
            BeanUtils.copyProperties(purchaseEntity,purchaseDto);
            purchaseDtoList.add(purchaseDto);
        });
        return purchaseDtoList;

    }

    @Override
    public PurchaseDto getOrderById(String id) {
        PurchaseEntity purchaseEntity = adminRepository.findOrderById(Integer.parseInt(id));
        PurchaseDto purchaseDto = new PurchaseDto();
        BeanUtils.copyProperties(purchaseEntity,purchaseDto);
        return purchaseDto;
    }

    @Override
    public boolean updateStatus(String id, OrderStatus orderStatus) {
        PurchaseEntity entity = adminRepository.findOrderById(Integer.parseInt(id));
        if (entity== null){
            return false;
        }
        entity.setOrderStatus(orderStatus);
        System.err.println(entity.toString());
        profileRepository.updateProfile(entity);
        return true;
    }

    @Override
    public List<PurchaseDto> getAllOrders() {
        List<PurchaseEntity> allOrders = adminRepository.findAllOrders();
        List<PurchaseDto> purchaseDtoList = new ArrayList<>();
        allOrders.forEach(purchaseEntity -> {
            PurchaseDto purchaseDto = new PurchaseDto();
            BeanUtils.copyProperties(purchaseEntity,purchaseDto);
            purchaseDtoList.add(purchaseDto);
        });
        return purchaseDtoList;
    }

    @Override
    public IssueCode addProduct(ProductMasterDTO productMasterDTO) {
        ProductMasterEntity productMasterEntity =new ProductMasterEntity();
        BeanUtils.copyProperties(productMasterDTO,productMasterEntity);
        System.err.println(productMasterEntity);
        boolean save = profileRepository.save(productMasterEntity);

        return null;
    }
}
