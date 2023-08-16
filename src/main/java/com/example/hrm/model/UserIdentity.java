package com.example.hrm.model;

import java.util.List;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserIdentity {
	@Id
	private String id;
	private String userId;
	private String identityType;
	private List<String> identityOptions;
	private boolean identityVerified;
	private String identityDocumentLink;
}
