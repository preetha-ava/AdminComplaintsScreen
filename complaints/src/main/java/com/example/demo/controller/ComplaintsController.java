package com.example.demo.controller;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.BL.BusinessLayer;
import com.example.demo.entity.BookingRequest;

import com.example.demo.entity.DriverInfo;
import com.example.demo.entity.DropPointBO;
import com.example.demo.entity.SourceBO;
import com.example.demo.entity.TripCabInfo;
import com.example.demo.entity.UserComplaints;
import com.example.demo.repo.DropPointRepository;
import com.example.demo.repo.EmployeeRepository;
import com.example.demo.repo.SourceRepository;
import com.example.demo.repo.TimeSlotRepository;


import com.example.demo.service.ComplaintsService;

@RestController
@RequestMapping(path="/api/v1")
public class ComplaintsController {
     @Autowired
     BusinessLayer BL;
     
     @Autowired
     MongoTemplate template;
     
// -------------------------***----------------------------------------// 
	
    // FindAll method--->starts
    //Find by Complaintsdesp
   @GetMapping(path="/complaints/complaintsdesp")

     public ResponseEntity<List<UserComplaints>> getComplaintsScreen(){
	
	   List<UserComplaints> trip=  this.BL.getComplaintsScreen();
	   
	return  ResponseEntity.status(HttpStatus.OK).body(trip);
	}
// -------------------------***----------------------------------------// 
 //@PutMapping annotation is used to map "/booking/{id}"Http PUT  request onto a specific handler method-update remark
   @PutMapping(path = "/remarks/{bookingId}/{remark}")
   public ResponseEntity<BookingRequest> updateRemark(@PathVariable("bookingId") long bookingId,@PathVariable("remark") String remark){
	   BookingRequest req = this.BL.updateRemark(bookingId,remark);
	   return  ResponseEntity.status(HttpStatus.OK).body(req);
   }
   
// -------------------------***----------------------------------------//   
 // Scroll method with MongoTemplate   
  @GetMapping(path="/scroll/{skip}/{limit}")
  public List<BookingRequest> getByScroll(@PathVariable("skip") long skip,@PathVariable("limit") int limit){
 	 Query query = new Query();
 	 query.limit(limit).skip(skip);
 	 
 	 List<BookingRequest> cabs=this.template.find(query, BookingRequest.class,"BookingRequest");
 	 return cabs;
  }
//-------------------------***----------------------------------------// 
  //To get the data count
	@GetMapping(path = "/count")
	public ResponseEntity<Long> getCount() {
		Long count = this.BL.getCount();
		return ResponseEntity.status(HttpStatus.OK).body(count);
	}
  
 


 

 
 
   
}

