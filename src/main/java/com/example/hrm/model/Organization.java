package com.example.hrm.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Organization {
	private String id;
	private String title;
	private String summary;
	private String tagLine;
	private String legalName;
	private String officialEmail;
	private Date registeredDate;
	private boolean status;
	private Date createdAt;
	private Date updatedAt;
}
