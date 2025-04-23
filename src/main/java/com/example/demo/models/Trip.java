package com.example.demo.models;
import jakarta.persistence.*;
import jakarta.persistence.Id;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
@Entity
@Table(name = "trips")
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime tripDate;
    private String origin;
    private String destination;
    private Double tripCost;

    @ManyToOne
    @JoinColumn(name = "captain_id")
    private Captain captain;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToOne(mappedBy = "trip", cascade = CascadeType.ALL)
    private Payment payment;

    // Constructors
    public Trip() {}
    public Trip(String origin, String destination, Double tripCost) {
        this.origin = origin;
        this.destination = destination;
        this.tripCost = tripCost;
    }
    public Trip(Long id, LocalDateTime tripDate, String origin, String destination, Double tripCost) {
        this.id = id;
        this.tripDate = tripDate;
        this.origin = origin;
        this.destination = destination;
        this.tripCost = tripCost;
    }
    public Trip( LocalDateTime tripDate, String origin, String destination, Double tripCost) {
        this.tripDate = tripDate;
        this.origin = origin;
        this.destination = destination;
        this.tripCost = tripCost;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDateTime getTripDate() { return tripDate; }
    public void setTripDate(LocalDateTime tripDate) { this.tripDate = tripDate; }

    public String getOrigin() { return origin; }
    public void setOrigin(String origin) { this.origin = origin; }

    public String getDestination() { return destination; }
    public void setDestination(String destination) { this.destination = destination; }

    public Double getTripCost() { return tripCost; }
    public void setTripCost(Double tripCost) { this.tripCost = tripCost; }

    public Captain getCaptain() { return captain; }
    public void setCaptain(Captain captain) { this.captain = captain; }

    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }

    public Payment getPayment() { return payment; }
    public void setPayment(Payment payment) { this.payment = payment; }}
