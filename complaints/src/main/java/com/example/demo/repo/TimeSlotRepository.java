package com.example.demo.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.entity.TimeslotBO;

public interface TimeSlotRepository extends MongoRepository<TimeslotBO, Integer> {

}
