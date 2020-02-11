package com.mastek.hrapp.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mastek.hrapp.entities.JobPositions;


public interface JobPositionsDAO extends MongoRepository<JobPositions, Integer>{

}
