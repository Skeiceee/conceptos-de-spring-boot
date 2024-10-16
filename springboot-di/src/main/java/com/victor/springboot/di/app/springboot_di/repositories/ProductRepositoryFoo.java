package com.victor.springboot.di.app.springboot_di.repositories;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.victor.springboot.di.app.springboot_di.models.Product;

@Repository("foo")
public class ProductRepositoryFoo implements ProductRepository{

    @Override
    public List<Product> findAll() {
        return Collections.singletonList(new Product(1L, "Mouser Zowie", 20000L));
    }

    @Override
    public Product findById(Long id) {
        return new Product(2L, "Mouser Razer", 30000L);
    }
    
}
