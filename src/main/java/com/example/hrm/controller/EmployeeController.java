package com.example.hrm.controller;

import com.example.hrm.dto.EmployeeData;
import com.example.hrm.model.Employee;
import com.example.hrm.model.User;
import com.example.hrm.service.EmployeeServicee;
import com.example.hrm.service.UserService;

import jakarta.validation.Valid;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeServicee employeeServicee;
	@Autowired
	private UserService userService;

	@GetMapping("/create/employee")
	public String addEmployee(@ModelAttribute EmployeeData employeeData) {
		return "addEmployee";
	}

	@PostMapping("/create/employee")
	public String addEmployeeSubmit(@Valid EmployeeData employee, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "addEmployee";
		}
		employeeServicee.addEmployee(employee);
		return "redirect:/list/employee";
	}

	@GetMapping({"/","/list/employee"})
	public String listEmployee(Model model) {
		List<EmployeeData> employeesData = employeeServicee.getEmployees().stream().map(employee-> {
			EmployeeData employeeData = new EmployeeData();
			employeeData.setEmployeeId(employee.getId());
			employeeData.setUserId(employee.getUserId());
			return employeeData;
		}).collect(Collectors.toList());
		List <EmployeeData> employeeUsers = employeesData.stream().map(employee -> {
			if(employee.getUserId() == null) {
				return employee;
			}
			User user = userService.getUserById(employee.getUserId());
			employee.setFirstName(user.getFirstName());
			employee.setLastName(user.getLastName());
			employee.setEmail(user.getEmail());
			employee.setBloodGroup(user.getBloodGroup());
			employee.setLastLoginDate(user.getLastLoginDate());
			employee.setMiddleName(user.getMiddleName());
			employee.setMobile(user.getMobile());
			employee.setPassword(user.getPassword());
			employee.setUsername(user.getUsername());
			return employee;
		}).collect(Collectors.toList());
		model.addAttribute("employees", employeeUsers);
		return "employeeList";
	}

	@PostMapping("/edit/employee/{id}")
	public String editEmployeeSubmit(@ModelAttribute EmployeeData employee, @PathVariable String id) {
		employee.setEmployeeId(id);
		employeeServicee.updateEmployee(employee);
		return "redirect:/";
	}
	@GetMapping("/edit/employee/{id}")
	public ModelAndView editEmployee(@ModelAttribute EmployeeData employee, @PathVariable String id) {
		ModelAndView modelAndView = new ModelAndView();
		Employee employeeFromDb = employeeServicee.findEmployeeById(id);
		EmployeeData employeeData = new EmployeeData();
		employeeData.setEmployeeId(employeeFromDb.getId());
		employeeData.setUserId(employeeFromDb.getUserId());
		if(employeeData.getUserId()!= null) {
			User user = userService.getUserById(employeeData.getUserId());
			employeeData.setFirstName(user.getFirstName());
			employeeData.setLastName(user.getLastName());
			employeeData.setEmail(user.getEmail());
			employeeData.setBloodGroup(user.getBloodGroup());
			employeeData.setLastLoginDate(user.getLastLoginDate());
			employeeData.setMiddleName(user.getMiddleName());
			employeeData.setMobile(user.getMobile());
			employeeData.setPassword(user.getPassword());
			employeeData.setUsername(user.getUsername());
		}
		modelAndView.addObject("employee", employeeData);
		modelAndView.addObject("id", id);
		modelAndView.setViewName("editEmployee");
		return modelAndView;
	}
	@GetMapping("/delete/employee/{id}")
	public String deleteEmployee(@PathVariable String id) {
		employeeServicee.deleteEmployeeById(id);
		return "redirect:/";
	}

}
