package com.tripPlanner.demo.models.dtos;

import com.tripPlanner.demo.models.enums.Climate;

import java.time.LocalDate;

public class TripDTO {

    private Long userId;

    private String destination;

    private LocalDate tripStartDate;

    private LocalDate tripEndDate;

    private Climate climate;

    public TripDTO(Long userId, String destination, LocalDate tripStartDate, LocalDate tripEndDate, Climate climate) {
        this.userId = userId;
        this.destination = destination;
        this.tripStartDate = tripStartDate;
        this.tripEndDate = tripEndDate;
        this.climate = climate;
    }

    public TripDTO() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDate getTripStartDate() {
        return tripStartDate;
    }

    public void setTripStartDate(LocalDate tripStartDate) {
        this.tripStartDate = tripStartDate;
    }

    public LocalDate getTripEndDate() {
        return tripEndDate;
    }

    public void setTripEndDate(LocalDate tripEndDate) {
        this.tripEndDate = tripEndDate;
    }

    public Climate getClimate() {
        return climate;
    }

    public void setClimate(Climate climate) {
        this.climate = climate;
    }
}
