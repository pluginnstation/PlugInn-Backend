package com.plugInnApp.userRegistration.service;

import com.plugInnApp.userRegistration.entity.UserLoginEntity;
import com.plugInnApp.userRegistration.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

public interface UserService {
    UserLoginEntity saveUserDetails(UserLoginEntity userLoginEntity);

    UserLoginEntity findByEmailId(String email);


}