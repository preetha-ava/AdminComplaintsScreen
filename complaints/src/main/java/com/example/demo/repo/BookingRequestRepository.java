package com.example.demo.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.demo.entity.BookingRequest;
import com.example.demo.entity.TripCabInfo;

public interface BookingRequestRepository extends MongoRepository<BookingRequest, Long> {

	TripCabInfo save(TripCabInfo info);

	

	@Query(value = "{remarks:null,complaintDescription:{$nin:[null]}}")
	List<BookingRequest> findBycomplaintDescription();

}
