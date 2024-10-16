package com.victor.curso.springboot.jpa.relaciones.sprinboot_jpa_relaciones.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.victor.curso.springboot.jpa.relaciones.sprinboot_jpa_relaciones.entities.Course;

public interface CourseRepository extends CrudRepository<Course, Long>{

    @Query("select c from Course c left join fetch c.students where c.id=?1")
    Optional<Course> findOneWithStudents(Long id);

}
