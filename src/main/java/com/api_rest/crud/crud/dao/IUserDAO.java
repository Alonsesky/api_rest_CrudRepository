package com.api_rest.crud.crud.dao;

import java.util.List;
import java.util.Optional;

import com.api_rest.crud.crud.model.User;

public interface IUserDAO {

    List<User> findAll();

    Optional<User> findById(Long id);

    void save(User user);

    void deleteById(Long id);

}
