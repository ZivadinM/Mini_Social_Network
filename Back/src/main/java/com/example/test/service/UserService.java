package com.example.test.service;

import com.example.test.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getAllUsers();

    Optional<User> findById(int id);

    User saveUser(User user);

    User updateUser(int jmbg, String firstname,String lastname, int years);
}
