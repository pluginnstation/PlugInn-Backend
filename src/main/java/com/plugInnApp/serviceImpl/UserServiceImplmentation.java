package com.plugInnApp.serviceImpl;

import com.plugInnApp.entity.UserLoginEntity;
import com.plugInnApp.repository.UserRepository;
import com.plugInnApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplmentation implements UserService {

    @Autowired
    UserRepository userRepository;
    @Override
    public UserLoginEntity saveUserDetails(UserLoginEntity userLoginEntity) {
        return userRepository.save(userLoginEntity);
    }

    @Override
    public UserLoginEntity findByEmailId(String email){
        return userRepository.findByEmail(email);
    }
}
