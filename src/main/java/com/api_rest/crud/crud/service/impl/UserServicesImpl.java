package com.api_rest.crud.crud.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.api_rest.crud.crud.model.User;
import com.api_rest.crud.crud.service.UserService;

@Service
public class UserServicesImpl implements UserService{

    @Override
    public List<User> allUsers() {
        return null;
    }

    @Override
    public Optional<User> findById(Long id) {
        return null;
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public void delete(User user) {
        
    }

}
