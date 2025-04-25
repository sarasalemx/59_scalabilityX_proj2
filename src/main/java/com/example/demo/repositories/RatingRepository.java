package com.example.demo.repositories;

import com.example.demo.models.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RatingRepository extends MongoRepository<Rating, String> {

    // Find ratings for a specific entity (by ID and type)
    List<Rating> findByEntityIdAndEntityType(Long entityId, String entityType);

    // Find ratings with score greater than value
    List<Rating> findByScoreGreaterThan(int minScore);
}

