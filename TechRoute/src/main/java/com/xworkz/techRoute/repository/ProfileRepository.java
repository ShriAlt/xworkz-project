package com.xworkz.techRoute.repository;

import com.xworkz.techRoute.entity.RegisterEntity;

public interface ProfileRepository {

   <S> boolean save(S entity);

    RegisterEntity checkByMail(String email);

    RegisterEntity checkByPhone(String phone);

   <T> boolean saveLoginInfo(T entity);

  <T> boolean updateProfile(T entity);

  boolean clearOtp();


}
