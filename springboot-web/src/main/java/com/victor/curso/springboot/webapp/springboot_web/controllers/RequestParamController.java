package com.victor.curso.springboot.webapp.springboot_web.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.victor.curso.springboot.webapp.springboot_web.models.dto.ParamDTO;

import jakarta.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/api/param")
public class RequestParamController {

    @GetMapping("/foo")
    public ParamDTO foo(@RequestParam(required = false, defaultValue = "Sin mensaje", name="mensaje") String message){
        ParamDTO paramDto = new ParamDTO(message);
        return paramDto;
    }

    @GetMapping("/bar")
    public ParamDTO bar(@RequestParam String text, @RequestParam Integer code){
        ParamDTO params = new ParamDTO(text, code);
        params.setMessage(text);
        params.setCode(code);
        return params;
    }

    @GetMapping("/request")
    public ParamDTO ParamDTO(HttpServletRequest request) {
        Integer code = 0;
        try {
            code = Integer.parseInt(request.getParameter("code"));
        } catch (NumberFormatException e) {
            // TODO: handle exception
        }

        ParamDTO params = new ParamDTO();
        params.setMessage(request.getParameter("text"));
        params.setCode(code);
        return params;
    }
    
}
