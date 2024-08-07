package com.api_rest.crud.crud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.api_rest.crud.crud.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    
}
