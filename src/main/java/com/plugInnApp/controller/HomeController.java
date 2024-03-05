package com.plugInnApp.controller;


import com.plugInnApp.entity.UserLoginEntity;
import com.plugInnApp.globalExceptions.ResourceNotFoundException;
import com.plugInnApp.repository.UserRepo;
import com.plugInnApp.service.UserService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
    @RequestMapping("/home")
public class HomeController {
    @Autowired
    private UserService userService;

    @Autowired
    UserRepo userLoginRepository;

    @GetMapping("/user")
    public List<UserLoginEntity> getUser(){
        System.out.println("Getting users");
        return this.userService.findAllUser();
    }
    @GetMapping("/allLogin")
    public String getLoggedInUser(Principal principal){
        return principal.getName();
    }
    @GetMapping("/test")
    public String getTestApi(){
        return "testing Api";
    }

}