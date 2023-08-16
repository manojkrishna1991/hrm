package com.example.hrm.dto;

import java.util.Date;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeData {
	private String employeeId;
	@NotEmpty(message = "firstName name cannot be empty.")
	@Size(min=2, max=50)
	private String firstName;
	@NotNull
	@NotEmpty(message = "lastName name cannot be empty.")
	@Size(min=2, max=50)
	private String lastName;
	@NotNull
	private String middleName;
	@NotEmpty(message = "username cannot be empty.")
	@Size(min=2, max=50)
	private String username;
	@NotEmpty(message = "email  cannot be empty.")
	@Size(min=2, max=50)
	private String email;
	@NotEmpty(message = "mobile  cannot be empty.")
	@Size(min=2, max=10)
	private String mobile;
	private String password;
	private Date registeredAt;
	private Date lastLoginDate;
	@NotEmpty(message = "bloodGroup  cannot be empty.")
	@Size(min=2, max=20)
	private String bloodGroup;
	private String userId;
	private String organizationId;
	@NotEmpty(message = "code  cannot be empty.")
	@Size(min=2, max=10)
	private String code;
}
