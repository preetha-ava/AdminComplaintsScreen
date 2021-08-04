package com.example.demo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.example.demo.entity.BookingRequest;
import com.example.demo.entity.DestinationBO;
import com.example.demo.entity.DriverInfo;
import com.example.demo.entity.EmployeeInfo;
import com.example.demo.entity.SourceBO;
import com.example.demo.entity.TripCabInfo;
import com.example.demo.entity.UserComplaintsBO;
import com.example.demo.repo.BookingRequestRepository;
import com.example.demo.repo.DestinationRepository;
import com.example.demo.repo.DriverInfoRepository;
import com.example.demo.repo.EmployeeRepository;
import com.example.demo.repo.SourceRepository;

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
	SourceRepository srcRepo;
	
	@Autowired
	DestinationRepository destRepo;
	
	
	@Autowired
	com.example.demo.repo.TripCabInfoRepository tripRepo;
	
  public TripCabInfo save(TripCabInfo info) {
		
		return this.repo.save(info);
	}
//ctrl + o - to list functions
  
//
public List<UserComplaintsBO>  getComplaintsScreen() {
List<UserComplaintsBO> uc =new ArrayList<>();
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
		
  Optional<TripCabInfo> tripCabOp = this.tripRepo.findById(eachBook.getTripCabId());
		
  TripCabInfo trip = tripCabOp.get();
	
  cabNumbers=trip.getCabNumber();
	
	dates=trip.getDateOfTravel();
		Optional<DriverInfo> driverOp = this.repo1.findById(trip.getDriverId());
		 driver = driverOp.get().getDriverName();
		
	
		 UserComplaintsBO userComplaints = new UserComplaintsBO();
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

public List<SourceBO> getSource() {
	// TODO Auto-generated method stub
	return this.srcRepo.findAll();
}

public List<DestinationBO> getDestination() {
	// TODO Auto-generated method stub
	return this.destRepo.findAll();
}



public List<UserComplaintsBO> getBySearch(String text, long skip, int limit) {

	List<UserComplaintsBO> uc = new ArrayList<>();

	Query query = new Query();
	Query empNameQuery = new Query();

	Criteria c = Criteria.where("employeeName").regex(text, "i");
	empNameQuery.addCriteria(c);

	List<BookingRequest> bookings = this.template.find(empNameQuery, BookingRequest.class);

	if(!(bookings.isEmpty())) {
		Long empNumbers = null;
		String cabNumbers = null;
		LocalDate dates = null;
		String driver = null;

		for (BookingRequest eachBook : bookings) {
	// By using employeeId getting
			Optional<EmployeeInfo> empOp = this.empRepo.findById(eachBook.getEmployeeId());

			EmployeeInfo emp = empOp.get();

			empNumbers = emp.getEmployeeNumber();

			Optional<TripCabInfo> tripCabOp = this.tripRepo.findById(eachBook.getTripCabId());

			TripCabInfo trip = tripCabOp.get();

			cabNumbers = trip.getCabNumber();

			dates = trip.getDateOfTravel();
			Optional<DriverInfo> driverOp = this.repo1.findById(trip.getDriverId());
			driver = driverOp.get().getDriverName();

			UserComplaintsBO userComplaints = new UserComplaintsBO();
			userComplaints.setDatesOfTravel(dates);
			userComplaints.setDriverName(driver);
			userComplaints.setEmpNumbers(empNumbers);
			userComplaints.setCabNumbers(cabNumbers);
			userComplaints.setRequests(eachBook);

			uc.add(userComplaints);

		}
	}
	else {
		
		Query cabNumberQuery = new Query();

		Criteria cabCriteria = Criteria.where("cabNumber").regex(text, "i");
		cabNumberQuery.addCriteria(cabCriteria);

		List<TripCabInfo> trips = this.template.find(cabNumberQuery, TripCabInfo.class);
		
		List<BookingRequest> requests = new ArrayList<BookingRequest>();
		
		for(TripCabInfo trip:trips) {
			
			Query tripQuery = new Query();

			Criteria tripCriteria = Criteria.where("tripCabId").is(trip.getTripCabId());
			Criteria compCriteria = Criteria.where("complaintDescription").ne(null);
			Criteria remarksCriteria = Criteria.where("remarks").is(null);
			
			Criteria c1 = new Criteria();
			c1.andOperator(tripCriteria,compCriteria,remarksCriteria);
			
			tripQuery.addCriteria(c1);
			
			requests.addAll(this.template.find(tripQuery, BookingRequest.class));
		}
			
			if(!(requests.isEmpty())){
				
				Long empNumbers = null;
				String cabNumbers = null;
				LocalDate dates = null;
				String driver = null;
			 	
			  for(BookingRequest eachBook:requests) {
			// By using employeeId getting
			  Optional<EmployeeInfo> empOp = this.empRepo.findById(eachBook.getEmployeeId());
					
			  EmployeeInfo emp  = empOp.get();
					
			  empNumbers=emp.getEmployeeNumber();
					
			  Optional<TripCabInfo> tripCabOp = this.tripRepo.findById(eachBook.getTripCabId());
					
			  TripCabInfo trip1 = tripCabOp.get();
				
			  cabNumbers=trip1.getCabNumber();
				
				dates=trip1.getDateOfTravel();
					Optional<DriverInfo> driverOp = this.repo1.findById(trip1.getDriverId());
					 driver = driverOp.get().getDriverName();
					
				
					 UserComplaintsBO userComplaints = new UserComplaintsBO();
					 userComplaints.setDatesOfTravel(dates);
					 userComplaints.setDriverName(driver);
					 userComplaints.setEmpNumbers(empNumbers);
					 userComplaints.setCabNumbers(cabNumbers);
					 userComplaints.setRequests(eachBook);
					 
					 uc.add(userComplaints);
					
				}

			}
			else {
				
				Query driverNameQuery = new Query();

				Criteria driverNameCriteria = Criteria.where("driverName").regex(text, "i");
				driverNameQuery.addCriteria(driverNameCriteria);
				
				List<DriverInfo> drvInfo = this.template.find(driverNameQuery, DriverInfo.class);
				
				List<TripCabInfo> tripCabs = new ArrayList<TripCabInfo>();
				
				List<BookingRequest> reqs = new ArrayList<BookingRequest>();
				
				for(DriverInfo drv:drvInfo) {
					Query drvQuery = new Query();

					Criteria drvCriteria = Criteria.where("driverId").is(drv.getDriverId());
					drvQuery.addCriteria(drvCriteria);
					
					tripCabs.addAll(this.template.find(drvQuery, TripCabInfo.class));
					
				}
				for(TripCabInfo trip:tripCabs) {
					
					Query tripQuery = new Query();

					Criteria tripCriteria = Criteria.where("tripCabId").is(trip.getTripCabId());
					Criteria compCriteria = Criteria.where("complaintDescription").ne(null);
					Criteria remarksCriteria = Criteria.where("remarks").is(null);
					
					Criteria c1 = new Criteria();
					c1.andOperator(tripCriteria,compCriteria,remarksCriteria);
					
					tripQuery.addCriteria(c1);
					
					reqs.addAll(this.template.find(tripQuery, BookingRequest.class));
				}
				
				Long empNumbers = null;
				String cabNumbers = null;
				LocalDate dates = null;
				String driver = null;
			 	
			  for(BookingRequest eachBook:reqs) {
			// By using employeeId getting
			  Optional<EmployeeInfo> empOp = this.empRepo.findById(eachBook.getEmployeeId());
					
			  EmployeeInfo emp  = empOp.get();
					
			  empNumbers=emp.getEmployeeNumber();
					
			  Optional<TripCabInfo> tripCabOp = this.tripRepo.findById(eachBook.getTripCabId());
					
			  TripCabInfo trip1 = tripCabOp.get();
				
			  cabNumbers=trip1.getCabNumber();
				
				dates=trip1.getDateOfTravel();
					Optional<DriverInfo> driverOp = this.repo1.findById(trip1.getDriverId());
					 driver = driverOp.get().getDriverName();
					
				
					 UserComplaintsBO userComplaints = new UserComplaintsBO();
					 userComplaints.setDatesOfTravel(dates);
					 userComplaints.setDriverName(driver);
					 userComplaints.setEmpNumbers(empNumbers);
					 userComplaints.setCabNumbers(cabNumbers);
					 userComplaints.setRequests(eachBook);
					 
					 uc.add(userComplaints);
					
				}
				
			}
			
			
			
		}
	

	return uc;
	
}
}
