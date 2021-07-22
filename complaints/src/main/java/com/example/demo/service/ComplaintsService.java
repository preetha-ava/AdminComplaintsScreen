package com.example.demo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.example.demo.entity.BookingRequest;
import com.example.demo.entity.DriverInfo;
import com.example.demo.entity.EmployeeInfo;
import com.example.demo.entity.TripCabInfo;
import com.example.demo.entity.UserComplaints;
import com.example.demo.repo.BookingRequestRepository;
import com.example.demo.repo.DriverInfoRepository;
import com.example.demo.repo.EmployeeRepository;

@Service(value ="ComplaintsService")
public class ComplaintsService {
	
	@Autowired
	MongoTemplate template;
	
	@Autowired
	BookingRequestRepository repo;
	
	@Autowired
	DriverInfoRepository repo1;
	
	@Autowired
	EmployeeRepository empRepo;
	
	
	@Autowired
	com.example.demo.repo.TripCabInfoRepository tripRepo;
	
  public TripCabInfo save(TripCabInfo info) {
		
		return this.repo.save(info);
	}
//ctrl + o - to list functions
  

public List<UserComplaints>  getComplaintsScreen() {
	
	//UserComplaints uc = new UserComplaints();
	List<UserComplaints> uc =new ArrayList<>();
//	Query query = new Query();
//	Criteria c1 = Criteria.where("remarks").is(null);
//	Criteria c2 = Criteria.where("complaintDescription").ne(null);
//	Criteria c = new Criteria();
//	c.andOperator(c1,c2);
//	query.addCriteria(c);
//	query.skip(skip).limit(limit);
//	List<BookingRequest> bookings = this.template.find(query, BookingRequest.class);
	List<BookingRequest> bookings =  this.repo.findBycomplaintDescription();
	
//	for(BookingRequest request :bookings) {
//	
//		uc.add(new UserComplaints(request, setEmpNo(request.getEmployeeId()),getDriverName(request.getTripCabId()) , getCabNumber(request.getTripCabId()), getDateOfTravel(request.getTripCabId())));
//	}
	
	
	
	Long empNumbers = null;
	String cabNumbers = null;
	LocalDate dates = null;
	String driver = null;
 	
   //Long	empNumbers=null;
   
	for(BookingRequest eachBook:bookings) {
		
		Optional<EmployeeInfo> empOp = this.empRepo.findById(eachBook.getEmployeeId());
		
		EmployeeInfo emp  = empOp.get();
		
		//empNumbers.add(emp.getEmployeeNumber());
		empNumbers=emp.getEmployeeNumber();
		
	Optional<com.example.demo.entity.TripCabInfo> tripCabOp = this.tripRepo.findById(eachBook.getTripCabId());
		
	TripCabInfo trip = tripCabOp.get();
	
	//cabNumbers.add(trip.getCabNumber());
	cabNumbers=trip.getCabNumber();
	//dates.add(trip.getDateoftravel());
	dates=trip.getDateoftravel();
		Optional<com.example.demo.entity.DriverInfo> driverOp = this.repo1.findById(trip.getDriverid());
		 driver = driverOp.get().getDriverName();
		
		//driverNames.add(driver.getDriverName());
		 UserComplaints userComplaints = new UserComplaints();
		 userComplaints.setDatesOfTravel(dates);
		 userComplaints.setDriverName(driver);
		 userComplaints.setEmpNumbers(empNumbers);
		 userComplaints.setCabNumbers(cabNumbers);
		 userComplaints.setRequests(eachBook);
		 
		 uc.add(userComplaints);
		
	}
	
	
	
	
	return uc;
}
public BookingRequest updateRemarks(long bookingId, String remark) {
	Optional<BookingRequest> requestOpt = this.repo.findById(bookingId);
	BookingRequest request = requestOpt.get();
	request.setRemarks(remark);
	return this.repo.save(request);
}


public Long getcount() {
	List<BookingRequest> tripcount=this.repo.findAll();
	return (long) tripcount.size()  ;
}
}
