package com.tripPlanner.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "transportation")
public class Transportation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "trip_id")
    private Trip trip; // may be more wise to change to day, relating to day by day

    @Column
    private String departureDestination;

    @Column
    private String arrivalDestination;

    @Column(name = "departure_time_and_date")
    private LocalDateTime departureTimeAndDate;

    @Column(name = "arrival_time_and_date")
    private LocalDateTime arrivalTimeAndDate;

    @Column(name = "mode_of_travel")
    @Enumerated(EnumType.STRING)
    private ModeOfTravel mode;

    public Transportation(Trip trip, String departureDestination, String arrivalDestination, LocalDateTime departureTimeAndDate, LocalDateTime arrivalTimeAndDate, ModeOfTravel mode) {
        this.trip = trip;
        this.departureDestination = departureDestination;
        this.arrivalDestination = arrivalDestination;
        this.departureTimeAndDate = departureTimeAndDate;
        this.arrivalTimeAndDate = arrivalTimeAndDate;
        this.mode = mode;
    }

    public Transportation() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public String getDepartureDestination() {
        return departureDestination;
    }

    public void setDepartureDestination(String departureDestination) {
        this.departureDestination = departureDestination;
    }

    public String getArrivalDestination() {
        return arrivalDestination;
    }

    public void setArrivalDestination(String arrivalDestination) {
        this.arrivalDestination = arrivalDestination;
    }

    public LocalDateTime getDepartureTimeAndDate() {
        return departureTimeAndDate;
    }

    public void setDepartureTimeAndDate(LocalDateTime departureTimeAndDate) {
        this.departureTimeAndDate = departureTimeAndDate;
    }

    public LocalDateTime getArrivalTimeAndDate() {
        return arrivalTimeAndDate;
    }

    public void setArrivalTimeAndDate(LocalDateTime arrivalTimeAndDate) {
        this.arrivalTimeAndDate = arrivalTimeAndDate;
    }

    public ModeOfTravel getMode() {
        return mode;
    }

    public void setMode(ModeOfTravel mode) {
        this.mode = mode;
    }
}
