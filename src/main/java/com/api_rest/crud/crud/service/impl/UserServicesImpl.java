package com.api_rest.crud.crud.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api_rest.crud.crud.model.dao.IUserDAO;
import com.api_rest.crud.crud.model.entity.User;
import com.api_rest.crud.crud.service.IUserService;

@Service
public class UserServicesImpl implements IUserService{

    @Autowired
    private IUserDAO userDAO;

    @Override
    public List<User> allUsers() {
        return userDAO.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userDAO.findById(id);
    }

    @Override
    public User save(User user) {
        userDAO.save(user);
        return user;
    }

    @Override
    public void delete(Long id) {
        userDAO.deleteById(id);
    }

}
