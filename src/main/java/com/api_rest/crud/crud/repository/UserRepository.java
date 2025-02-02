package com.api_rest.crud.crud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.api_rest.crud.crud.model.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    //Aquí se impleplementa los metodos propios!
}
