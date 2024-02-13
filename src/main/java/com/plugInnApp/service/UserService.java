package com.plugInnApp.service;

import com.plugInnApp.entity.UserLoginEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserLoginEntity createUser(UserLoginEntity userLoginEntity);

    UserLoginEntity findByEmailId(String email);

    List<UserLoginEntity> findAllUser();

}