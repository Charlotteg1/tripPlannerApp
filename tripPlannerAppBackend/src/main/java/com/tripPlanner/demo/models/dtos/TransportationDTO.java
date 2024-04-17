package com.tripPlanner.demo.models.dtos;

import com.tripPlanner.demo.models.enums.ModeOfTransport;

import java.time.LocalDateTime;

public class TransportationDTO {

    private Long tripId;

    private String departureDestination;

    private String arrivalDestination;

    private LocalDateTime departureTimeAndDate;

    private LocalDateTime arrivalTimeAndDate;

    private ModeOfTransport mode;

    public TransportationDTO(Long tripId, String departureDestination, String arrivalDestination, LocalDateTime departureTimeAndDate, LocalDateTime arrivalTimeAndDate, ModeOfTransport mode) {
        this.tripId = tripId;
        this.departureDestination = departureDestination;
        this.arrivalDestination = arrivalDestination;
        this.departureTimeAndDate = departureTimeAndDate;
        this.arrivalTimeAndDate = arrivalTimeAndDate;
        this.mode = mode;
    }

    public Long getTripId() {
        return tripId;
    }

    public void setTripId(Long tripId) {
        this.tripId = tripId;
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

    public ModeOfTransport getMode() {
        return mode;
    }

    public void setMode(ModeOfTransport mode) {
        this.mode = mode;
    }
}
