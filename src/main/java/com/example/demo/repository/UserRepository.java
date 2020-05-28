package com.example.demo.repository;

import com.example.demo.entity.UserObject;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<UserObject, Integer> {}
