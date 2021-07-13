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
@Document(collection =  "BookingRequest")
public class BookingRequest {
	@Id
  private long bookingId;
  private long employeeId;
  private String employeeName;
  private long tripCabId;
  private String complaintDescription;
  private String source;
  private String destination;
  private String droppoint;
  private LocalTime bookingtime;
  private LocalTime timeslot;
  private String remarks;
  private String addedmanually;
  private String createdby;
  private String createddate;
  private String modifiedby;
  private String modifieddate;
  private String isdeleted;
  
  
  
  
  
}
