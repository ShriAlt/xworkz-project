package com.xworkz.techRoute.repository;

import com.xworkz.techRoute.entity.UserEntity;
import org.springframework.stereotype.Repository;

public interface UserRepository {

    boolean saveUser(UserEntity userEntity);

    UserEntity checkByMail(String email);

    UserEntity checkByPhone(String phone);

}
