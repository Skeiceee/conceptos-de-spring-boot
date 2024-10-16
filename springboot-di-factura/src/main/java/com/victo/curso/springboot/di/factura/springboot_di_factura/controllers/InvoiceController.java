package com.victo.curso.springboot.di.factura.springboot_di_factura.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.victo.curso.springboot.di.factura.springboot_di_factura.models.Invoice;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api")
public class InvoiceController {
    @Autowired
    private Invoice invoice;

    @GetMapping("show")
    public Invoice show() {
        return invoice;
    }
}
