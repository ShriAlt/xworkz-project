package com.xworkz.techRoute.repository;

import com.xworkz.techRoute.entity.LoginEntity;
import com.xworkz.techRoute.entity.UserEntity;

public interface UserRepository {

    boolean saveUser(UserEntity userEntity);

    UserEntity checkByMail(String email);

    UserEntity checkByPhone(String phone);

    boolean saveLoginInfo(LoginEntity loginEntity);

}
