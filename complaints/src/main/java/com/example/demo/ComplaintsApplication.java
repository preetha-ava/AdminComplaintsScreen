package com.example.demo;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.entity.BookingRequest;
import com.example.demo.entity.EmployeeInfo;
import com.example.demo.entity.TripCabInfo;
import com.example.demo.repo.BookingRequestRepository;
import com.example.demo.repo.DriverInfoRepository;
import com.example.demo.repo.EmployeeRepository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@SpringBootApplication
public class ComplaintsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComplaintsApplication.class, args);
	
	
	
}
   @Bean
	public CommandLineRunner runner()
	{
		return new CommandLineRunner() {
			
			@Autowired
			BookingRequestRepository bookingRepo;
			
			@Autowired
			DriverInfoRepository driverRepo;
			
			@Autowired
			com.example.demo.repo.TripCabInfoRepository tripRepo;
			
			@Autowired
			EmployeeRepository empRepo;
			
			
			@Override
			public void run(String... args) throws Exception {
				
				EmployeeInfo employee4 = new EmployeeInfo(7, "dhivya", 878764310 , "Arvinth" , "CabProject" , "Rohit", 0,0,  null, null, null, null, null);
				this.empRepo.save(employee4);
				BookingRequest booking=new BookingRequest(1,1,"Preetha",1,"inproper dress code","alpha city","Tambaram","AGS",null,LocalTime.of(10, 30),null,null,null,null,null,null,null);
				this.bookingRepo.save(booking); 
				BookingRequest booking2 = new BookingRequest(2, 2, "prasna", 1, "Drunk and drive", "Alpha city", "Tambaram", "doller", null, LocalTime.of(10, 30), null, null, null, null, null, null, null);
				this.bookingRepo.save(booking2);
				BookingRequest booking3 = new BookingRequest(3, 3, "Farh", 1, "Drunk and drive", "Alpha city", "Tambaram", "doller", null, LocalTime.of(10, 30), null, null, null, null, null, null, null);
				this.bookingRepo.save(booking3);
				BookingRequest booking4 = new BookingRequest(4, 4, "akshaya", 1, "Drunk ", "Alpha city", "Tambaram", "doller", null, LocalTime.of(10, 30), null, null, null, null, null, null, null);
				this.bookingRepo.save(booking4);
				BookingRequest booking5 = new BookingRequest(5, 5, "amirtha", 1, "Drunk  ", "Alpha city", "Tambaram", "doller", null, LocalTime.of(10, 30), null, null, null, null, null, null, null);
				this.bookingRepo.save(booking5);
				BookingRequest booking6 = new BookingRequest(6, 6, "aruna", 1, "Drunk  ", "Alpha city", "Tambaram", "doller", null, LocalTime.of(10, 30), null, null, null, null, null, null, null);
				this.bookingRepo.save(booking6);
				BookingRequest booking7 = new BookingRequest(7, 7, "dhivya", 1, "Drunk  ", "Alpha city", "Tambaram", "doller", null, LocalTime.of(10, 30), null, null, null, null, null, null, null);
				this.bookingRepo.save(booking7);
				
				
				TripCabInfo trip=new TripCabInfo(1,"TN809",1,LocalDate.of(2021, 05, 07));
     			this.tripRepo.save(trip);
				com.example.demo.entity.DriverInfo driverdetails= new com.example.demo.entity.DriverInfo(1, "Ravi", null, 0, 0, null, null, null, null, null);
				this.driverRepo.save(driverdetails);
			}
		};
	}

	}
	
				
