package com.example.demo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.entity.BookingRequest;
import com.example.demo.entity.DestinationBO;
import com.example.demo.entity.DropPointBO;
import com.example.demo.entity.EmployeeInfo;
import com.example.demo.entity.SourceBO;
import com.example.demo.entity.TimeslotBO;
import com.example.demo.entity.TripCabInfo;
import com.example.demo.repo.BookingRequestRepository;
import com.example.demo.repo.DestinationRepository;
import com.example.demo.repo.DriverInfoRepository;
import com.example.demo.repo.EmployeeRepository;
import com.example.demo.repo.SourceRepository;

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
			
			@Autowired
			SourceRepository souRepo;
			
			@Autowired
			DestinationRepository desRepo;
			
			
			@Override
			public void run(String... args) throws Exception {
				
				EmployeeInfo employee4 = new EmployeeInfo("AVA-100", "abi", 878764310 , "Arvinth" , "CabProject" , "Rohit", 0,0,  null, null, null, null, null);
				this.empRepo.save(employee4);
				BookingRequest booking=new BookingRequest(1,"AVA-101","Preetha",1,"inproper dress code","AlphaCity","Tambaram","AGS",null,LocalTime.of(10, 30),null,null,null,null,null,null,null);
				this.bookingRepo.save(booking); 
				BookingRequest booking2 = new BookingRequest(2,"AVA-102" , "prasna", 1, "Drunk and drive", "AlphaCity", "Tambaram", "doller", null, LocalTime.of(10, 30), null, null, null, null, null, null, null);
				this.bookingRepo.save(booking2);
				BookingRequest booking3 = new BookingRequest(3, "AVA-103", "Farh", 1, "Drunk and drive", "AlphaCity", "Tambaram", "doller", null, LocalTime.of(10, 30), null, null, null, null, null, null, null);
				this.bookingRepo.save(booking3);
				BookingRequest booking4 = new BookingRequest(4, "AVA-104", "akshaya", 1, "Drunk ", "AlphaCity", "Tambaram", "doller", null, LocalTime.of(12, 30), null, null, null, null, null, null, null);
				this.bookingRepo.save(booking4);
				BookingRequest booking5 = new BookingRequest(5, "AVA-105", "amirtha", 1, "Drunk  ", "BayLine", "Tambaram", "doller", null, LocalTime.of(23, 30), null, null, null, null, null, null, null);
				this.bookingRepo.save(booking5);
				BookingRequest booking6 = new BookingRequest(6, "AVA-106", "aruna", 1, "Drunk  ", "BayLine", "Tambaram", "doller", null, LocalTime.of(11, 30), null, null, null, null, null, null, null);
				this.bookingRepo.save(booking6);
				BookingRequest booking7 = new BookingRequest(7, "AVA-107", "abi", 1, "Drunk  ", "BayLine", "Tambaram", "doller", null, LocalTime.of(12, 30), null, null, null, null, null, null, null);
				this.bookingRepo.save(booking7);
				
				
				TripCabInfo trip=new TripCabInfo(1,"TN809",1,LocalDate.of(2021, 05, 07));
     			this.tripRepo.save(trip);
				com.example.demo.entity.DriverInfo driverdetails= new com.example.demo.entity.DriverInfo(1, "Ravi", null, 0, 0, null, null, null, null, null);
				this.driverRepo.save(driverdetails);
				
				SourceBO source1=new SourceBO("BayLine", null, null, null, null, 0);
				this.souRepo.save(source1);
				
				SourceBO source2=new SourceBO("AlphaCity", null, null, null, null, 0);
				this.souRepo.save(source2);
				
				
               
                TimeslotBO slot1=new TimeslotBO(LocalTime.of(20, 30), null, null, null, null, 0);
                TimeslotBO slot2=new TimeslotBO(LocalTime.of(21, 00), null, null, null, null, 0);
                TimeslotBO slot3=new TimeslotBO(LocalTime.of(23, 30), null, null, null, null, 0);
                List<TimeslotBO> list2=new ArrayList<>();
                list2.add(slot1);
                list2.add(slot2);
                list2.add(slot3);
                
                DropPointBO drop1 = new DropPointBO("Medavakkam", null, null, null, null, 0);
                DropPointBO drop2 = new DropPointBO("Tambaram", null, null, null, null, 0);
                List<DropPointBO> drops = new ArrayList<DropPointBO>();
                drops.add(drop1);
                drops.add(drop2);
               
                DestinationBO dest1=new DestinationBO("Tambaram", drops, list2, null, null, null, null, 0);
                desRepo.save(dest1);
                

				
				
			}
		};
	}

	}
	
				
