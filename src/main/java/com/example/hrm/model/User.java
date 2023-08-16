package com.example.hrm.model;

import java.util.Date;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	@Id
	private String id;
	private String firstName;
	private String lastName;
	private String middleName;
	private String username;
	private String email;
	private String mobile;
	private String password;
	private Date registeredAt;
	private Date lastLoginDate;
	private String bloodGroup;
}
