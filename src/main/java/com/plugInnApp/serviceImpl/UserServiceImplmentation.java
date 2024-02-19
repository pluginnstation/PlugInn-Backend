package com.plugInnApp.serviceImpl;

import com.plugInnApp.entity.UserLoginEntity;
import com.plugInnApp.repository.UserRepository;
import com.plugInnApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImplmentation implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public UserLoginEntity createUser(UserLoginEntity userLoginEntity) {
        userLoginEntity.setUserId(UUID.randomUUID().toString());
        userLoginEntity.setPassword(passwordEncoder.encode(userLoginEntity.getPassword()));
        return userRepository.save(userLoginEntity);
    }

    @Override
    public UserLoginEntity findByEmailId(String email){
        return userRepository.findByEmail(email);
    }

    @Override
    public List<UserLoginEntity> findAllUser() {
        return userRepository.findAll();
    }


    public Optional<UserLoginEntity> findUserById(String userId) {
        return userRepository.findById(userId);
    }


}
