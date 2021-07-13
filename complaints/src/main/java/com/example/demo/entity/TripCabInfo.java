package com.example.demo.entity;


import java.time.LocalDate;
//import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="TripCabInfo")
public class TripCabInfo {
	@Id
	private long tripCabId;
	private String cabNumber;
	private long driverid;
	private String source;
	private LocalTime timeSlot;
	private String cabmodel;
	private String destination;
	private String droppoint;
	private LocalDate dateoftravel;
	private long totalseats;
	private long remainingseats;
	private long allocatedseats;
	private LocalDate starttime;
	private LocalDate endtime;
	private String createdby;
	private String createddate;
	private String modifiedby;
	private String modifieddate;
	public TripCabInfo(long tripCabId, String cabNumber, long driverid,LocalDate dateoftravel) {
		super();
		this.tripCabId = tripCabId;
		this.cabNumber = cabNumber;
		this.driverid = driverid;
		
		this.dateoftravel=dateoftravel;
		
	}
	
	
	
}
