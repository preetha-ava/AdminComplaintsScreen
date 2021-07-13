package com.example.demo.entity;

import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimeslotBO {

	 private long timeSlotId;
	 private LocalTime time;
}
