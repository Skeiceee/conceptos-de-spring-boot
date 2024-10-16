package com.victor.curso.springboot.webapp.springboot_web.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.victor.curso.springboot.webapp.springboot_web.models.User;

@Controller
public class UserController {
    
    @GetMapping("/details")
    public Map<String, Object> details(Model model){

        User user = new User("Victor", "Nuñez");

        Map<String, Object> body = new HashMap<>();

        body.put("title", "Titulo en Spring Boot");
        body.put("user", user);
        
        return body;
    }

    @GetMapping("/list")
    public String list(ModelMap model){
        model.addAttribute("title", "Listado de usuarios");
        return "list";
    }

    @ModelAttribute("users")
    public List<User> usersModel(){
        List<User> users = new ArrayList<>();
        users.add(new User("Victor", "Nuñez", "victoralejandronunezt@gmail.com"));
        users.add(new User("Martina", "Mendez", "martina@gmail.com"));
        users.add(new User("Carlos", "Soto", "carlos@gmail.com"));
        users.add(new User("Juan", "Perez"));
        return users;
    }

}
