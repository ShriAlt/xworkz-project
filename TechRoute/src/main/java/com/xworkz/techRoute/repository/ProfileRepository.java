package com.xworkz.techRoute.repository;

import com.xworkz.techRoute.entity.CustomerEntity;
import com.xworkz.techRoute.entity.RegisterEntity;

import java.util.List;

public interface ProfileRepository {

   <S> boolean save(S entity);

    RegisterEntity checkByMail(String email);

    RegisterEntity checkByPhone(String phone);

//   <T> boolean saveLoginInfo(T entity);

  <T> boolean updateProfile(T entity);

  boolean clearOtp();

  List<CustomerEntity> findAll();

  CustomerEntity fetchCustomerEntity(int id);

  boolean deleteCustomer(int id);

    CustomerEntity fetchCustomerEntityByMail(String email);

    CustomerEntity fetchCustomerEntityByNumber(String number);

}
