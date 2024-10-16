package com.victor.curso.springboot.error.springboot_error.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.victor.curso.springboot.error.springboot_error.models.Error;

@RestControllerAdvice
public class HandlerExceptionController {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<?> divisionByZero(Exception ex){

        Error error = new Error();

        error.setDate(new Date());
        error.setMessage(ex.getMessage());
        error.setError("No se puede dividir por cero");
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());

        // return ResponseEntity.internalServerError().body(error);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(error);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<Error> notFound(NoHandlerFoundException ex){
        Error error = new Error();

        error.setDate(new Date());
        error.setMessage(ex.getMessage());
        error.setError("No se encontro");
        error.setStatus(HttpStatus.NOT_FOUND.value());

        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(error);
    }

    @ExceptionHandler(NumberFormatException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> notFound(NumberFormatException ex){

        Map<String, Object> json = new HashMap<>();
        
        json.put("date", new Date());
        json.put("error", "Formato de numero incorrecto.");
        json.put("message", ex.getMessage());
        json.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());

        return json;
    }

    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Error> noSuchElementException(NoSuchElementException ex){
        Error error = new Error();

        error.setDate(new Date());
        error.setMessage(ex.getMessage());
        error.setError("No se encontro");
        error.setStatus(HttpStatus.NOT_FOUND.value());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}   
