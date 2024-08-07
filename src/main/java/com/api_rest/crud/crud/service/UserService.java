package com.api_rest.crud.crud.service;

import java.util.List;
import java.util.Optional;

import com.api_rest.crud.crud.model.User;

public interface UserService {

    List<User> allUsers();

    Optional<User> findById(Long id);

    User save(User user);

    void delete(User user);
}
