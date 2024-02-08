package com.plugInnApp.service;

import com.plugInnApp.entity.UserLoginEntity;

public interface UserService {
    UserLoginEntity saveUserDetails(UserLoginEntity userLoginEntity);

   UserLoginEntity findByEmailId(String email);


}