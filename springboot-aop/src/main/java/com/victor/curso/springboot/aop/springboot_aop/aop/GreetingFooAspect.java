package com.victor.curso.springboot.aop.springboot_aop.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Aspect
@Component
public class GreetingFooAspect extends GreetingServicePointcuts{

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Before("greetingFooAspectPointcut()")
    public void beforeLogger(JoinPoint joinPoint){
        
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        logger.info("Desde GreetingFooAspect() - Antes del metodo " + method + " con los argumentos " + args);

    }

    @After("greetingFooAspectPointcut()")
    public void afterLogger(JoinPoint joinPoint){
        
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        logger.info("Desde GreetingFooAspect() - Despues del metodo " + method + " con los argumentos " + args);

    }
}
