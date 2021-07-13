package com.example.demo.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "DriverInfo")
public class DriverInfo {
	@Id
 private long driverid;
 private String driverName;
 private String password;
 private long drivernumber;
 private long licensenumber;
 private LocalDate expirydate;
 private String createdby;
 private String createddate;
 private String modifiedby;
 private String modifieddate;
//public DriverInfo(String driverName) {
//	super();
//	this.driverName = driverName;
//}
public DriverInfo(long driverid, String driverName, String password, long drivernumber, long licensenumber,
		LocalDate expirydate, String createdby, String createddate, String modifiedby, String modifieddate) {
	super();
	this.driverid = driverid;
	this.driverName = driverName;
	this.password = password;
	this.drivernumber = drivernumber;
	this.licensenumber = licensenumber;
	this.expirydate = expirydate;
	this.createdby = createdby;
	this.createddate = createddate;
	this.modifiedby = modifiedby;
	this.modifieddate = modifieddate;
}
 
 
}
