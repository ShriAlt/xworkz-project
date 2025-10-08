package com.xworkz.techRoute.repository;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

    public UserRepositoryImpl(){
        System.out.println("no args of UserRepositoryImpl");
    }


    @Override
    public boolean saveUser() {


        return false;
    }
}
