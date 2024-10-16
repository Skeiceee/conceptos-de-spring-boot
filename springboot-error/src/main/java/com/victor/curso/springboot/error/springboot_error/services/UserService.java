package com.victor.curso.springboot.error.springboot_error.services;

import java.util.List;
import java.util.Optional;

import com.victor.curso.springboot.error.springboot_error.models.User;

public interface UserService {

    public Optional<User> findById(Long id);
    public List<User> findAll();
}
