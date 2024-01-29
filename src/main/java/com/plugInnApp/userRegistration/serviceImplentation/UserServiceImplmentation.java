package com.plugInnApp.userRegistration.serviceImplentation;

import com.plugInnApp.userRegistration.entity.UserLoginEntity;
import com.plugInnApp.userRegistration.repository.UserRepository;
import com.plugInnApp.userRegistration.service.UserService;
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
}
