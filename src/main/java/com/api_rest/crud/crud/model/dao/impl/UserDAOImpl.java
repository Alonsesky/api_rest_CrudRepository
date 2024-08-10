package com.api_rest.crud.crud.model.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api_rest.crud.crud.model.dao.IUserDAO;
import com.api_rest.crud.crud.model.entity.User;
import com.api_rest.crud.crud.repository.UserRepository;

@Component
public class UserDAOImpl implements IUserDAO {

// Conectamos con el Repository
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

}
