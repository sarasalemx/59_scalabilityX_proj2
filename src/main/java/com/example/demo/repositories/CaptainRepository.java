package com.example.demo.repositories;

import com.example.demo.models.Captain;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CaptainRepository extends JpaRepository<Captain, Long> {

    // Find captains with avg rating score greater than threshold
    List<Captain> findByAvgRatingScoreGreaterThan(Double ratingThreshold);

    // Find captain by license number
    Captain findByLicenseNumber(String licenseNumber);
}
