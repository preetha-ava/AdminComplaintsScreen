package com.example.demo.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface DriverInfoRepository extends MongoRepository<com.example.demo.entity.DriverInfo, Long> {

}
