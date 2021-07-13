package com.example.demo.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.entity.SourceBO;

public interface SourceRepository extends MongoRepository<SourceBO, Integer> {

}
