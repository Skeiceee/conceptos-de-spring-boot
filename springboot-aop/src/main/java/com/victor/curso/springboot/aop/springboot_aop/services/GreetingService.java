package com.victor.curso.springboot.aop.springboot_aop.services;

import java.util.Map;

public interface GreetingService {

    Map<String, Object> sayHello(String person, String phrase);
    Map<String, Object> sayHelloError(String person, String phrase);
    Map<String, Object> sayGoodbye(String person, String phrase);

}
