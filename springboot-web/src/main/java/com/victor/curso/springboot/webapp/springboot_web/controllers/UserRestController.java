package com.victor.curso.springboot.webapp.springboot_web.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.victor.curso.springboot.webapp.springboot_web.models.User;
import com.victor.curso.springboot.webapp.springboot_web.models.dto.UserDTO;

@RestController
@RequestMapping("/api")
public class UserRestController {

    @RequestMapping(path = "/user/details", method = RequestMethod.GET)
    public Map<String, Object> details(){
        
        User user = new User("Victor", "Nuñez");
        
        Map<String, Object> body = new HashMap<>();

        body.put("title", "Titulo");
        body.put("user", user);

        return body;
    }

    @RequestMapping(path = "/user/dto/details", method = RequestMethod.GET)
    public UserDTO detailsDTO(){
        User user = new User("Victor", "Nuñez");
            
        UserDTO userDTO = new UserDTO();

        userDTO.setTitle("Titulo de UserDTO");
        userDTO.setUser(user);

        return userDTO;
    }

    @RequestMapping(path = "/user/list", method = RequestMethod.GET)
    public List<User> list(){

        User user = new User("Martina", "Mendez");
        User user2 = new User("Victor", "Nuñez");
        User user3 = new User("Carlos", "Soto");

        // List<User> users = Arrays.asList(user, user2, user3);
        
        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(user2);
        users.add(user3);

        return users;
    }

}
