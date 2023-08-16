package com.example.hrm.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.hrm.model.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {
}
