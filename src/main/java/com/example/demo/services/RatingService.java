package com.example.demo.services;

import com.example.demo.models.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.example.demo.repositories.RatingRepository;


@Service
public class RatingService {

    private final RatingRepository ratingRepository;

    @Autowired
    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    // 8.5.2.1 Add Rating
    public Rating addRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    // 8.5.2.2 Update Rating
    public Rating updateRating(String id, Rating updatedRating) {
        Optional<Rating> optionalRating = ratingRepository.findById(id);
        if (optionalRating.isPresent()) {
            Rating rating = optionalRating.get();
            rating.setScore(updatedRating.getScore());
            rating.setComment(updatedRating.getComment());
            rating.setRatingDate(updatedRating.getRatingDate());
            return ratingRepository.save(rating);
        }
        return null; // or throw custom NotFoundException
    }

    // 8.5.2.3 Delete Rating
    public void deleteRating(String id) {
        ratingRepository.deleteById(id);
    }

    // 8.5.2.4 Get Ratings By Entity
    public List<Rating> getRatingsByEntity(Long entityId, String entityType) {
        return ratingRepository.findByEntityIdAndEntityType(entityId, entityType);
    }

    // 8.5.2.5 Find Ratings Above a Specific Value
    public List<Rating> findRatingsAboveScore(int minScore) {
        return ratingRepository.findByScoreGreaterThan(minScore);
    }
}

