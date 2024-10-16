package com.victor.curso.springboot.aop.springboot_aop.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService{

    @Override
    public Map<String, Object> sayHello(String person, String phrase) {

        Map<String, Object> json = new HashMap<>();

        StringBuilder string = new StringBuilder();
        string.append(phrase);
        string.append(" ");
        string.append(person);
        string.append("!");

        json.put("greeting", string);
        
        return json;
    }

    @Override
    public Map<String, Object> sayHelloError(String person, String phrase) {
        throw new UnsupportedOperationException("Unimplemented method 'sayHelloError'");
    }

    @Override
    public Map<String, Object> sayGoodbye(String person, String phrase) {
        throw new UnsupportedOperationException("Unimplemented method 'sayHelloError'");
    }


}
