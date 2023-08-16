package com.example.hrm.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Employee {
    @Id
    public String id;
    private String userId;
    private String OrganizationId;
    private String roleId;
    private String code;
    private String contractId;
}
