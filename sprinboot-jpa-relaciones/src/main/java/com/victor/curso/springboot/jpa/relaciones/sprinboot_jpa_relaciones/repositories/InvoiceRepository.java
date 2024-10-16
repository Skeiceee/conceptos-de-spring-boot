package com.victor.curso.springboot.jpa.relaciones.sprinboot_jpa_relaciones.repositories;

import org.springframework.data.repository.CrudRepository;

import com.victor.curso.springboot.jpa.relaciones.sprinboot_jpa_relaciones.entities.Invoice;

public interface InvoiceRepository extends CrudRepository<Invoice, Long>{

}
