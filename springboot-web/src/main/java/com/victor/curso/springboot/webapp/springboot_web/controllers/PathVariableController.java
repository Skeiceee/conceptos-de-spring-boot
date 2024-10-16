package com.victor.curso.springboot.webapp.springboot_web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.victor.curso.springboot.webapp.springboot_web.models.User;
import com.victor.curso.springboot.webapp.springboot_web.models.dto.ParamDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/pathvar/")
public class PathVariableController {

    @Value("${config.apiToken}")
    private String apiToken;

    @Value("${config.listOfValues}")
    private List<String> listOfValues;
    
    @Value("#{${config.map}}")
    private Map<String, Object> oneMap;

    @Value("#{'${config.listOfValues}'.toUpperCase()}")
    private String stringListOfValues;

    @Autowired
    private Environment env;

    @GetMapping("/prueba/value")
    public Map<String, Object> getMethodName() {
        Map<String, Object> json = new HashMap<>();
        json.put("apiToken", apiToken);
        json.put("listOfValues", listOfValues);
        json.put("stringListOfValues", stringListOfValues);
        json.put("oneMap", oneMap);
        json.put("envApiToken", env.getProperty("config.apiToken"));
        json.put("envOneMap", env.getProperty("config.map"));
        return json;
    }
    
    @GetMapping("/baz/{message}")
    public ParamDTO baz(@PathVariable String message) {
        ParamDTO paramDTO = new ParamDTO();
        paramDTO.setMessage(message);
        return paramDTO;
    }
    
    @GetMapping("/mix/{product}/{id}")
    public Map<String, Object> mixPathVar(@PathVariable String product, @PathVariable Long id) {

        Map<String, Object> json = new HashMap<>();

        json.put("id", id);
        json.put("product", product);

        return json;
    }

    
    @PostMapping("/create")
    public User create(@RequestBody User user) {

        user.setName(user.getName().toUpperCase());
        return user;
    }
    
}
