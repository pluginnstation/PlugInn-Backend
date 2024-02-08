package com.plugInnApp.controller;

import com.plugInnApp.globalExceptions.ResourceNotFoundException;
import com.plugInnApp.entity.UserLoginEntity;
import com.plugInnApp.repository.UserRepository;
import com.plugInnApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class UserRegistrationController {

    @Autowired
    UserService userService;
    @Autowired
    UserRepository userLoginRepository;

    @PostMapping("/userLogin")
    public UserLoginEntity saveUserData(@RequestBody UserLoginEntity userLoginEntity) {
        UserLoginEntity user = userService.findByEmailId(userLoginEntity.getEmail());
        if (user == null) {
            return userService.saveUserDetails(userLoginEntity);
        }
        else{
            return user;
        }
    }

    @PutMapping("editProfile/{userId}")
    public UserLoginEntity updateUserData(@RequestBody UserLoginEntity userLoginEntity,@PathVariable Integer userID){
        UserLoginEntity updateUserLoginDetails = userLoginRepository.findById(userID).orElseThrow(() -> new ResourceNotFoundException("Cannot update the user with this Id "+ userID));
       updateUserLoginDetails.setEmail(userLoginEntity.getEmail());
       updateUserLoginDetails.setCarNumber(userLoginEntity.getCarNumber());
       updateUserLoginDetails.setCarModelDescription(userLoginEntity.getCarModelDescription());
       updateUserLoginDetails.setEmail(userLoginEntity.getEmail());
       return userLoginRepository.save(updateUserLoginDetails);
    }

}
