package com.victor.springboot.di.app.springboot_di.repositories;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.victor.springboot.di.app.springboot_di.models.Product;

@Repository
public class ProductRepositoryJson implements ProductRepository{

    private List<Product> products;

    public ProductRepositoryJson(){
        Resource resource = new ClassPathResource("json/products.json");
        readValueJson(resource);
    }

    public ProductRepositoryJson(Resource resource){
        readValueJson(resource);
    }

    public void readValueJson(Resource resource){
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            products = Arrays.asList(objectMapper.readValue(resource.getFile(), Product[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Product findById(Long id) {
        return products.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow();
    }

}
