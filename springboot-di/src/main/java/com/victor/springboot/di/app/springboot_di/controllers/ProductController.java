package com.victor.springboot.di.app.springboot_di.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.victor.springboot.di.app.springboot_di.models.Product;
import com.victor.springboot.di.app.springboot_di.services.ProductService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public List<Product> findAll() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product getMethodName(@PathVariable Long id) {
        return productService.findById(id);
    }
    
}
