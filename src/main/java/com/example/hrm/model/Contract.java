package com.example.hrm.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contract {
	private String id;
	private String contractType;
	private Date contractStartDate;
	private Date contactEndDate;
	private boolean isContractExpired;
}
