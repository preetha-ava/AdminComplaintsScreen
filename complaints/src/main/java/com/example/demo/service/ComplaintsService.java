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
  
//
public List<UserComplaints>  getComplaintsScreen() {
List<UserComplaints> uc =new ArrayList<>();
//get complaintsdescription from bookingrepository
List<BookingRequest> bookings =  this.repo.findBycomplaintDescription();
	Long empNumbers = null;
	String cabNumbers = null;
	LocalDate dates = null;
	String driver = null;
 	
  for(BookingRequest eachBook:bookings) {
// By using employeeId getting
  Optional<EmployeeInfo> empOp = this.empRepo.findById(eachBook.getEmployeeId());
		
  EmployeeInfo emp  = empOp.get();
		
  empNumbers=emp.getEmployeeNumber();
		
  Optional<com.example.demo.entity.TripCabInfo> tripCabOp = this.tripRepo.findById(eachBook.getTripCabId());
		
  TripCabInfo trip = tripCabOp.get();
	
  cabNumbers=trip.getCabNumber();
	
	dates=trip.getDateoftravel();
		Optional<com.example.demo.entity.DriverInfo> driverOp = this.repo1.findById(trip.getDriverid());
		 driver = driverOp.get().getDriverName();
		
	
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
//Admin sends a response by passing bookingID and remarks to database 
public BookingRequest updateRemarks(long bookingId, String remark) {
	Optional<BookingRequest> requestOpt = this.repo.findById(bookingId);
	BookingRequest request = requestOpt.get();
	request.setRemarks(remark);
	return this.repo.save(request);
}

//Function-to get the data count.
public Long getcount() {
	List<BookingRequest> tripcount=this.repo.findAll();
	return (long) tripcount.size()  ;
}
}
