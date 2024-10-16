package com.victor.curso.springboot.error.springboot_error.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.victor.curso.springboot.error.springboot_error.models.User;
import com.victor.curso.springboot.error.springboot_error.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/api")
public class AppController {

    @Autowired
    private UserService userService;

    @GetMapping("/prueba")
    public Integer index() {

        // int value = 100/0;
        int value = Integer.parseInt("10000x");
        
        return value;
    }
    
    @GetMapping("user/{id}")
    public User getMethodName(@PathVariable Long id) {
        User user = userService.findById(id).orElseThrow();
        return user;
    }
    
    
}
