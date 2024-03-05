package com.plugInnApp.controller;

import com.plugInnApp.entity.UserLoginEntity;
import com.plugInnApp.globalExceptions.ResourceNotFoundException;
import com.plugInnApp.model.JwtRequest;
import com.plugInnApp.model.JwtResponse;
import com.plugInnApp.repository.UserRepo;
import com.plugInnApp.repository.UserRepository;
import com.plugInnApp.security.JwtHelper;
import com.plugInnApp.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private AuthenticationManager manager;
    @Autowired
    private JwtHelper helper;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    private Logger logger = LoggerFactory.getLogger(AuthController.class);
    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest request){
        doAuthenticate(request.getEmail(), request.getPassword());
        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());
        String token = this.helper.generateToken(userDetails);
        JwtResponse response = JwtResponse.builder()
                .jwtToken(token)
                .userName(userDetails.getUsername()).build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    private void doAuthenticate(String email, String password){
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email,password);
        try{
            manager.authenticate(authentication);
        }catch (BadCredentialsException e){
            throw new BadCredentialsException("Invalid UserName or Password !!");
        }
    }
    @ExceptionHandler(BadCredentialsException.class)
    public String exceptionHandler() {
        return "Credentials Invalid !!";
    }
    
    @PostMapping("/createUser")
    public UserLoginEntity saveUserData(@RequestBody UserLoginEntity userLoginEntity) {
        UserLoginEntity user = userService.findByEmailId(userLoginEntity.getEmail());
        if (user == null) {
            return userService.createUser(userLoginEntity);
        }
        else{
            return user;
        }
    }
    @PutMapping("/editProfile/{id}")
    public UserLoginEntity updateUserData(@RequestBody UserLoginEntity userLoginEntity, @PathVariable String id){

        UserLoginEntity user = userRepository.findByEmail(userLoginEntity.getEmail());

        Optional<UserLoginEntity> updateUserLoginDetails = userRepository.findById(id);
        String tempEmail = userLoginEntity.getEmail();
        if(updateUserLoginDetails.isPresent()){
        updateUserLoginDetails.get().setName(userLoginEntity.getName());
        updateUserLoginDetails.get().setFamilyName(userLoginEntity.getFamilyName());
        updateUserLoginDetails.get().setPassword(userLoginEntity.getPassword());
//        updateUserLoginDetails.get().setEmail(userLoginEntity.getEmail());
        }
        return userRepository.save(updateUserLoginDetails.get());
    }





}