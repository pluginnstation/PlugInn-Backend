package com.plugInnApp.userRegistration.controller;

import com.plugInnApp.userRegistration.entity.UserLoginEntity;
import com.plugInnApp.userRegistration.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class UserRegistrationController {

    @Autowired
    UserService userService;

    @PostMapping("/userLogin")
    public UserLoginEntity saveUserData(@RequestBody UserLoginEntity userLoginEntity){

        return userService.saveUserDetails(userLoginEntity);
    }

}
