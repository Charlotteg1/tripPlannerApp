package com.tripPlanner.demo.models.dtos;

import com.tripPlanner.demo.models.Day;
import com.tripPlanner.demo.models.enums.AccommodationType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.util.List;

public class AccommodationDTO {
    private List<Long> dayIds;

    private String name;

    private AccommodationType type;

    private String bookingDetails;

    private String address;

    public AccommodationDTO(List<Long> dayIds, String name, AccommodationType type, String bookingDetails, String address) {
        this.dayIds = dayIds;
        this.name = name;
        this.type = type;
        this.bookingDetails = bookingDetails;
        this.address = address;
    }

    public List<Long> getDayIds() {
        return dayIds;
    }

    public void setDayIds(List<Long> dayIds) {
        this.dayIds = dayIds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AccommodationType getType() {
        return type;
    }

    public void setType(AccommodationType type) {
        this.type = type;
    }

    public String getBookingDetails() {
        return bookingDetails;
    }

    public void setBookingDetails(String bookingDetails) {
        this.bookingDetails = bookingDetails;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
