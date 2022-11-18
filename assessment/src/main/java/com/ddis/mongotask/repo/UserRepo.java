package com.ddis.mongotask.repo;

import com.ddis.mongotask.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends MongoRepository<User, String> {
    Optional<User> findById(Long id);
    List<User> findByStateAndCity(String state, String city);
}