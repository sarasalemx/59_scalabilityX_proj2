package com.example.demo.models;

import jakarta.persistence.*;
import jakarta.persistence.Id;

@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;
    private String paymentMethod;
    private Boolean paymentStatus;

    @OneToOne
    @JoinColumn(name = "trip_id")
    private Trip trip;

    // Constructors
    public Payment() {}
    public Payment(Double amount, String method) {
        this.amount = amount;
        this.paymentMethod = method;
    }
    public Payment(Double amount, String method, Boolean paymentStatus) {
        this.amount = amount;
        this.paymentMethod = method;
        this.paymentStatus = paymentStatus;
    }
    public Payment(Long id, Double amount, String method, Boolean status) {
        this.id = id;
        this.amount = amount;
        this.paymentMethod = method;
        this.paymentStatus = status;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }

    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }

    public Boolean getPaymentStatus() { return paymentStatus; }
    public void setPaymentStatus(Boolean paymentStatus) { this.paymentStatus = paymentStatus; }

    public Trip getTrip() { return trip; }
    public void setTrip(Trip trip) { this.trip = trip; }}
