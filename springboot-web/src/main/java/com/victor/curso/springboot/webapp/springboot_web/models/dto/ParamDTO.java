package com.victor.curso.springboot.webapp.springboot_web.models.dto;

public class ParamDTO {
    private String message;
    private Integer code; 

    public ParamDTO(){
        this.message = null;
        this.code = null;
    }

    public ParamDTO(String message){
        this.message = message;
    }

    public ParamDTO(String message, Integer code){
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    } 

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

}
