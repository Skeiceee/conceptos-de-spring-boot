package com.victor.springboot.di.app.springboot_di;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.io.Resource;

import com.victor.springboot.di.app.springboot_di.repositories.ProductRepository;
import com.victor.springboot.di.app.springboot_di.repositories.ProductRepositoryJson;

@Configuration
@PropertySources({
	@PropertySource(value="classpath:config.properties", encoding="UTF-8")
})
public class Config {
	
	@Value("classpath:json/products.json")
	private Resource resource;
	
	@Bean("productJson")
	public ProductRepository ProductRepositoryJson(){
		return new ProductRepositoryJson(resource);
	}
}
