package com.example.springbootdemo.repository;

import com.example.springbootdemo.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

}