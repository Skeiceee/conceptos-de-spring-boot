package com.victor.curso.springboot.error.springboot_error.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.victor.curso.springboot.error.springboot_error.models.User;

@Service
public class UserServiceImpl implements UserService{

    private List<User> users;

    public UserServiceImpl(){
        List<User> users = new ArrayList<>();
        users.add(new User(1L, "Victor", "Nuñez"));
        users.add(new User(2L, "Martina", "Mendez"));
        users.add(new User(3L, "Carlos", "Soto"));
        users.add(new User(4L, "Juan", "Perez"));

        this.users = users;
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public Optional<User> findById(Long id) {
        User user = null;

        // for(User u : users){
        //     if(u.getId().equals(id)){
        //         user = u;
        //     }
        // }

        user = users.stream()
            .filter(
                u -> u.getId().equals(id)
            )
            .findFirst()
            .orElseThrow();


        return Optional.ofNullable(user);

    }
    
}
