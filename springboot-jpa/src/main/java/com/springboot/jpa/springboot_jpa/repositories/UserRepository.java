package com.springboot.jpa.springboot_jpa.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.springboot.jpa.springboot_jpa.dto.UserDTO;
import com.springboot.jpa.springboot_jpa.entities.User;
import java.util.List;
import java.util.Optional;


public interface UserRepository extends CrudRepository<User, Long>{

    public List<User> findByLastname(String lastname);
    public List<User> findByNameAndLastname(String name, String lastname);
    public List<User> findByIdBetween(Long min, Long max);
    public List<User> findByIdBetweenAndNameLike(Long min, Long max, String name);
    public List<User> findByIdBetweenOrderByNameDesc(Long min, Long max);
    public List<User> findByIdBetweenOrderByLastnameAscNameDesc(Long min, Long max);

    @Query("select u from User u where u.name = ?1 and u.lastname = ?2")
    public List<User> buscarPorNombreYApellido(String name, String lastname);

    @Query("select u.name, u.lastname from User u")
    public List<Object[]> getUserData();

    @Query("select u from User u where u.id = ?1")
    public Optional<User> findOne(Long id);

    @Query("select u from User u where u.name like %?1%")
    public Optional<User> findOneLikeName(String name);

    @Query("select u from User u where u.name like %?1%")
    public List<Optional<User>> findAllLikeName(String name);

    @Query("select u.name from User u where u.id = ?1")
    public String getNameById(Long id);

    @Query("select concat(u.name, ' ', u.lastname) as fullname from User u where u.id = ?1")
    public String getFullNameById(Long id);

    @Query("select concat(u.name, ' ', u.lastname) as fullname from User u")
    // public List<Object[]> getListFullName();
    public List<String> getListFullName();

    @Query("select concat(u.name, ' ', u.lastname) as fullname, age, createdAt, updatedAt from User u")
    public List<Object[]> findAllUser();

    @Query("select u, u.age  from User u")
    public List<Object[]> findAllMixUser();

    @Query("select new User(u.lastname, u.name, u.age) from User u")
    public List<User> findAllClassUser();

    @Query("select new com.springboot.jpa.springboot_jpa.dto.UserDTO(u.name, u.lastname) from User u")
    public List<UserDTO> findAllClassUserDTO();

    @Query("select distinct(u.lastname) from User u")
    public List<String> findAllClassDistinctUser();

    @Query("select concat(u.name, ' ', u.lastname) from User u")
    public List<String> fullnameConcat();

    @Query("select upper(concat(u.name, ' ', u.lastname)) from User u")
    public List<String> fullnameUpperConcat();

    @Query("select lower(concat(u.name, ' ', u.lastname)) from User u")
    public List<String> fullnameLowerConcat();

    @Query("select u from User u where u.id between ?1 and ?2")
    public List<User> betweenExample(Integer min,  Integer max);

    @Query("select count(u) from User u")
    public Long countUsers();

    @Query("select max(u.id) from User u")
    public Long maxUsers();

    @Query("select min(u.id) from User u")
    public Long minUsers();

    @Query("select u.name, length(u.name) from User u")
    public List<Object[]> lengthUsers();

    @Query("select min(length(u.name)) from User u")
    public List<Object[]> minLengthUsers();

    @Query("select max(length(u.name)) from User u")
    public List<Object[]> maxLengthUsers();

    @Query("select u.name, length(u.name) from User u where length(u.name) = (select min(length(u.name)) from User u)")
    public List<Object[]> getShorterName();

    @Query("select u.name, length(u.name) from User u where length(u.name) = (select max(length(u.name)) from User u)")
    public List<Object[]> getLongerName();

    @Query("select u from User u where id in (1, 3, 4)")
    public List<Object[]> whereIn();

    @Query("select u from User u where id in ?1")
    public List<Object[]> whereIn(List<Long> ids);
    
}
