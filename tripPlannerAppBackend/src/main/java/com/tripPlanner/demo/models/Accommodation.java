package com.tripPlanner.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "accommodations")
public class Accommodation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Enumerated(EnumType.STRING)
    private AccommodationType type;

    @Column
    private String bookingDetails;
    //act as notes for the user, so they can store a booking reference, check in time etc

    public Accommodation(String name, AccommodationType type, String bookingDetails) {
        this.name = name;
        this.type = type;
        this.bookingDetails = bookingDetails;
    }

    public Accommodation() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
