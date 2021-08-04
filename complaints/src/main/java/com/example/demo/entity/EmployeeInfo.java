package com.example.demo.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="Employee")
public class EmployeeInfo {
	@Id
 String employeeId;
 String employeeName;
 long employeeNumber;
 String domainlead;
 String projectName;
 String projectLead;
 int isAdmin;
 int isBlocked;
 LocalDate blocked;
 String createdBy;
 String modifiedBy;
 String modifieddate;
 String deleted;
 
 
 
 
}
