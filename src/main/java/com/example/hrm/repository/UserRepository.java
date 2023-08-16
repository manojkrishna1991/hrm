package com.example.hrm.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.hrm.model.User;
@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
