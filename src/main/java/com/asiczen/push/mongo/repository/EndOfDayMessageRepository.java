package com.asiczen.push.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.asiczen.push.mongo.model.EndOfDayMessage;

@Repository
public interface EndOfDayMessageRepository extends MongoRepository<EndOfDayMessage, String> {

}
