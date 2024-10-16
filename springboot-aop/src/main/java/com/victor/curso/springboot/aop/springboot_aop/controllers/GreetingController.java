package com.victor.curso.springboot.aop.springboot_aop.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.victor.curso.springboot.aop.springboot_aop.services.GreetingService;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api")
public class GreetingController {

    @Autowired
    private GreetingService greetingService;

    @GetMapping("/saludar")
    public ResponseEntity<Map<String, Object>> saludar() {
        Map<String, Object> json = greetingService.sayHello("Victor", "Hola");
        return ResponseEntity.ok(json);
    }    

    @GetMapping("/error/saludar")
    public ResponseEntity<Map<String, Object>> saludarError() {
        Map<String, Object> json = greetingService.sayHelloError("Victor", "Hola");
        return ResponseEntity.ok(json);
    }

}
