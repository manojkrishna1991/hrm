package com.example.hrm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEmergencyContact {
	private String id;
	private String userId;
	private String primaryEmergencyContactNumber;
	private String primaryRelationShipType;
	private String secondaryEmergencyContactNumber;
	private String secondaryRelationShipType;
}
