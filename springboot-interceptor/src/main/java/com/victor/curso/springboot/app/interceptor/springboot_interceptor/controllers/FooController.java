package com.victor.curso.springboot.app.interceptor.springboot_interceptor.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api")
public class FooController {

    @GetMapping("/foo")
    public Map<String, String> foo() {

        return Collections.singletonMap("hola", "mundo");
    }

    @GetMapping("/foo2")
    public String foo2() {
        return "Esto es una prueba de interceptors.";
    }

    @GetMapping("/foo3")
    public String foo3() {
        return "Esto es una prueba de interceptors.";
    }

    @GetMapping("/foo4")
    public String foo4() {
        return "Esto es una prueba de interceptors.";
    }

}
