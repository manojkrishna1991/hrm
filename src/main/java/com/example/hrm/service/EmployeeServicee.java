package com.example.hrm.service;

import com.example.hrm.dto.EmployeeData;
import com.example.hrm.model.Employee;
import com.example.hrm.model.User;
import com.example.hrm.repository.EmployeeRepository;
import com.example.hrm.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeServicee {
	@Autowired
	private UserRepository userRepository;

    @Autowired
    private EmployeeRepository employeeRepository;
    public Employee addEmployee(EmployeeData employeeData) {
    	User user = new User();
    	user.setEmail(employeeData.getEmail());
    	user.setFirstName(employeeData.getFirstName());
    	user.setLastName(employeeData.getLastName());
    	user.setBloodGroup(employeeData.getBloodGroup());
    	user.setLastLoginDate(new Date());
    	user.setMiddleName(employeeData.getMiddleName());
    	user.setMobile(employeeData.getMobile());
    	user.setPassword(UUID.randomUUID().toString());
    	user.setRegisteredAt(new Date());
    	User userFromDb = userRepository.save(user);
    	Employee employee = new Employee();
    	employee.setCode(employee.getCode());
    	employee.setOrganizationId(employee.getOrganizationId());
    	employee.setUserId(userFromDb.getId());
        return employeeRepository.save(employee);
    }

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }
    public void updateEmployee(EmployeeData employeeData) {
    	Optional<Employee> employeeFromDb = employeeRepository.findById(employeeData.getEmployeeId());
    	if(employeeFromDb.isPresent()) {
    		Employee actualEmployee = employeeFromDb.get();
    		String userId = actualEmployee.getUserId();
    		if(userId == null) {
    			User user = new User();
    	    	user.setEmail(employeeData.getEmail());
    	    	user.setFirstName(employeeData.getFirstName());
    	    	user.setLastName(employeeData.getLastName());
    	    	user.setBloodGroup(employeeData.getBloodGroup());
    	    	user.setLastLoginDate(new Date());
    	    	user.setMiddleName(employeeData.getMiddleName());
    	    	user.setMobile(employeeData.getMobile());
    	    	user.setPassword(UUID.randomUUID().toString());
    	    	user.setRegisteredAt(new Date());
    	    	User userFromDb = userRepository.save(user);
    	    	actualEmployee.setCode(employeeData.getCode());
    	    	actualEmployee.setOrganizationId(employeeData.getOrganizationId());
    	    	actualEmployee.setUserId(userFromDb.getId());
    		}
    		else {
    			User user = userRepository.findById(userId).get();
    			if(user != null) {
    				user.setEmail(employeeData.getEmail());
        	    	user.setFirstName(employeeData.getFirstName());
        	    	user.setLastName(employeeData.getLastName());
        	    	user.setBloodGroup(employeeData.getBloodGroup());
        	    	user.setLastLoginDate(new Date());
        	    	user.setMiddleName(employeeData.getMiddleName());
        	    	user.setMobile(employeeData.getMobile());
        	    	user.setPassword(UUID.randomUUID().toString());
        	    	User userFromDb = userRepository.save(user);
        	    	actualEmployee.setCode(employeeData.getCode());
        	    	actualEmployee.setOrganizationId(employeeData.getOrganizationId());
        	    	actualEmployee.setUserId(userFromDb.getId());
    			}
    		}
    		employeeRepository.save(actualEmployee);
    	}else {
    		throw new RuntimeException("Employee not found");
    	}
    }
    public Employee findEmployeeById(String id) {
    	return employeeRepository.findById(id).get();
    }
    public void deleteEmployeeById(String id) {
    	employeeRepository.deleteById(id);
    }
}
