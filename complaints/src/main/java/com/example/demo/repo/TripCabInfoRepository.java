package com.example.demo.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TripCabInfoRepository extends MongoRepository<com.example.demo.entity.TripCabInfo, Long> {

}
