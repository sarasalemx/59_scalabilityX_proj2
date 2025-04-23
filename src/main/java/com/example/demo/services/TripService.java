package com.example.demo.services;

import com.example.demo.models.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.example.demo.repositories.TripRepository;

@Service
public class TripService {

    private final TripRepository tripRepository;

    @Autowired
    public TripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    // 8.3.2.1 Add Trip
    public Trip addTrip(Trip trip) {
        return tripRepository.save(trip);
    }

    // 8.3.2.2 Get All Trips
    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }

    // 8.3.2.3 Get Trip By ID
    public Trip getTripById(Long id) {
        Optional<Trip> optionalTrip = tripRepository.findById(id);
        return optionalTrip.orElse(null); // or throw custom NotFoundException
    }

    // 8.3.2.4 Update Trip
    public Trip updateTrip(Long id, Trip updatedTrip) {
        return tripRepository.findById(id).map(trip -> {
            trip.setTripDate(updatedTrip.getTripDate());
            trip.setOrigin(updatedTrip.getOrigin());
            trip.setDestination(updatedTrip.getDestination());
            trip.setTripCost(updatedTrip.getTripCost());
            trip.setCaptain(updatedTrip.getCaptain());
            trip.setCustomer(updatedTrip.getCustomer());
            return tripRepository.save(trip);
        }).orElse(null); // or throw custom NotFoundException
    }

    // 8.3.2.5 Delete Trip
    public void deleteTrip(Long id) {
        tripRepository.deleteById(id);
    }

    // 8.3.2.6 Find Trips Within a Date Range
    public List<Trip> findTripsWithinDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        return tripRepository.findByTripDateBetween(startDate, endDate);
    }

    // 8.3.2.7 Find Trips By Captain ID
    public List<Trip> findTripsByCaptainId(Long captainId) {
        return tripRepository.findByCaptainId(captainId);
    }
}

