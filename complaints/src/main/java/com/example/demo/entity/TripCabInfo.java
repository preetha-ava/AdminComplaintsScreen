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
	private  long tripCabId;
	private String cabNumber;
	private long driverId;
	private String source;
	private String destination;
	private LocalDate dateOfTravel;
	private LocalTime timeSlot;
	private int totalSeats;
	private int allocatedSeats;
	private int remainingSeats;
	private String status;
	private LocalTime startTime;
	private LocalTime endTime;
	private String CreatedBy;
	   private LocalDate CreatedDate;
	private String ModifiedBy;
	private LocalDate modifiedDate;
	private int isDeleted;
	public TripCabInfo(long tripCabId, String cabNumber, long driverId,LocalDate dateoftravel) {
		super();
		this.tripCabId = tripCabId;
		this.cabNumber = cabNumber;
		this.driverId = driverId;
		
		this.dateOfTravel=dateoftravel;
		
	}
	
	
	
}
