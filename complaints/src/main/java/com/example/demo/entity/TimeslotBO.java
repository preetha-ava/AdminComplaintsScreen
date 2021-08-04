package com.example.demo.entity;

import java.time.LocalDateTime;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimeslotBO {

	
	 private LocalTime time;
	 String createdBy;
	 LocalDateTime createdDate;
	 String modifiedBy;
	 LocalDateTime modifiedDate;
	 int isDeleted;
	 
}
