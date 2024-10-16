package com.victor.curso.springboot.jpa.relaciones.sprinboot_jpa_relaciones.repositories;

import org.springframework.data.repository.CrudRepository;

import com.victor.curso.springboot.jpa.relaciones.sprinboot_jpa_relaciones.entities.ClientDetails;

public interface ClientDetailsRepository extends CrudRepository<ClientDetails, Long>{

}
