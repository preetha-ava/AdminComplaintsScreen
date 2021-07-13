package com.example.demo.BL;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.example.demo.entity.BookingRequest;
import com.example.demo.entity.TripCabInfo;
import com.example.demo.entity.UserComplaints;
import com.example.demo.service.ComplaintsService;
@Component
public class BusinessLayer {

	@Autowired
	ComplaintsService service;
	public TripCabInfo save(TripCabInfo info) {

		return this.service.save(info);
	}

	public List<UserComplaints>  getComplaintsScreen() {

		return this.service.getComplaintsScreen();
	}

	

	public BookingRequest updateRemark(long bookingId, String remark) {
		// TODO Auto-generated method stub
		return this.service.updateRemarks(bookingId,remark);
	}

	


}
