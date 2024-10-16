package com.victor.curso.springboot.aop.springboot_aop.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Aspect
@Component
public class GreetingAspect extends GreetingServicePointcuts{

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Before("grettingAspectPointcut()")
    public void beforeLogger(JoinPoint joinPoint){
        
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        logger.info("Antes del metodo " + method + " con los argumentos " + args);

    }

    @After("grettingAspectPointcut()")
    public void afterLogger(JoinPoint joinPoint){
        
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        logger.info("Despues del metodo " + method + " con los argumentos " + args);

    }

    @AfterReturning("grettingAspectPointcut()")
    public void afterReturningLogger(JoinPoint joinPoint){
        
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        logger.info("Despues de retornar " + method + " con los argumentos " + args);

    }

    @AfterThrowing("grettingAspectPointcut()")
    public void afterThrowingLogger(JoinPoint joinPoint){
        
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        logger.info("@ Despues de lanzar la exepcion " + method + " con los argumentos " + args);

    }
    
    @Around("grettingAspectPointcut()")
    public Object loggerAround(ProceedingJoinPoint joinPoint) throws Throwable{
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        Object result = null;

        try {
            logger.info("El metodo " + method + "() con los argumentos " + args);
            result = joinPoint.proceed();
            logger.info("El metodo " + method + "() el resultado es " + result);
        } catch (Throwable e) {
            logger.info("Hubo un error en el metodo " + method + "() el error: " + e.getMessage());
            throw e;
        }

        return result;
    }
        
}
