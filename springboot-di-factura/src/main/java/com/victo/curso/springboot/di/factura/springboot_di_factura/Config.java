package com.victo.curso.springboot.di.factura.springboot_di_factura;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import com.victo.curso.springboot.di.factura.springboot_di_factura.models.Item;
import com.victo.curso.springboot.di.factura.springboot_di_factura.models.Product;

@Configuration
@PropertySource(value = "classpath:data.properties", encoding = "UTF-8")
public class Config {
    
    @Bean
    List<Item> itemsInvoices(){
        Product p1 = new Product("Camara Sony", 200000);
        Product p2 = new Product("Bicicleta Wethepeople", 600000);
        Product p3 = new Product("Teclado razer", 220000);
        Product p4 = new Product("Silla gamer", 300000);

        List<Item> items = Arrays.asList(
            new Item(p1, 1),
            new Item(p2, 3),
            new Item(p3, 2),
            new Item(p4, 1)
        );

        return items;
    }

    @Bean
    @Primary
    List<Item> itemsInvoicesOficina(){
        Product p1 = new Product("Monitor Gigabyte", 500000);
        Product p2 = new Product("Mouse", 300000);
        Product p3 = new Product("Teclado razer", 320000);
        Product p4 = new Product("Silla ergonomica", 400000);

        List<Item> items = Arrays.asList(
            new Item(p1, 1),
            new Item(p2, 3),
            new Item(p3, 2),
            new Item(p4, 1)
        );

        return items;
    }

}
