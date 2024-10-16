package com.victor.curso.springboot.jpa.relaciones.sprinboot_jpa_relaciones.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.victor.curso.springboot.jpa.relaciones.sprinboot_jpa_relaciones.entities.Client;

public interface ClientRepository extends CrudRepository<Client, Long>{

    @Query("select c from Client c left join fetch c.addresses where c.id=?1")
    Optional<Client> findOne(Long id);

    @Query("select c from Client c left join fetch c.invoices where c.id=?1")
    Optional<Client> findOneWithInvoices(Long id);

    @Query("select c from Client c left join fetch c.invoices left join fetch c.addresses left join fetch c.clientDetails where c.id=?1")
    Optional<Client> findOneAll(Long id);

}
