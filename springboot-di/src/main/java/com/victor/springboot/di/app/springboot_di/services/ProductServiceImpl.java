package com.victor.springboot.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.victor.springboot.di.app.springboot_di.models.Product;
import com.victor.springboot.di.app.springboot_di.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    @Qualifier("productJson")
    private ProductRepository repository;

    @Autowired
    private Environment env;

    @Override
    public List<Product> findAll(){
        
        List<Product> products;

        products = repository.findAll().stream().map(
            p -> {
                Double priceTax = p.getPrice() * env.getProperty("config.tax", Double.class);

                Product product = new Product(p.getId(), p.getName(), priceTax.longValue());
                product = (Product) p.clone();
                product.setPrice(priceTax.longValue());

                return product;
            }
        ).collect(Collectors.toList());

        return products;
    }

    @Override
    public Product findById(Long id){
        return repository.findById(id);
    }
}
