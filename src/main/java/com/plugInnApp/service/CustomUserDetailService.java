package com.plugInnApp.service;


import com.plugInnApp.entity.UserLoginEntity;
import com.plugInnApp.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;
  @Override
    public UserLoginEntity loadUserByUsername(String username) throws UsernameNotFoundException {
        UserLoginEntity user = userRepo.findByEmail(username).orElseThrow(() ->new RuntimeException("User not found"));
        return user;
    }

}
