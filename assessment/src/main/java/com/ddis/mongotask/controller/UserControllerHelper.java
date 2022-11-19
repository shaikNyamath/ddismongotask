package com.ddis.mongotask.controller;

import com.ddis.mongotask.dto.UserResponseDTO;
import com.ddis.mongotask.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.TypedAggregation;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserControllerHelper {
    @Autowired
    UserRepo userRepo;
    @Autowired
    MongoTemplate mongoTemplate;
    public List<UserResponseDTO> getUserResponseDTOS() {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.group("city").count().as("userCount"),
                Aggregation.project("userCount").and("city").previousOperation()
        );
        AggregationResults<UserResponseDTO> groupResults = mongoTemplate.aggregate((TypedAggregation<?>) aggregation, UserResponseDTO.class);
        List<UserResponseDTO> result = groupResults.getMappedResults();
        return result;
    }

}
