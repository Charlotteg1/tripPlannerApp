package com.tripPlanner.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "accommodation")
public class Accommodation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Day day;

    @Column
    private String name;

    @Enumerated(EnumType.STRING)
    private AccommodationType type;

    @Column
    private String bookingDetails;
    //act as notes for the user, so they can store a booking reference, check in time etc

    @Column
    private String address;

    public Accommodation(Day day, String name, AccommodationType type, String bookingDetails, String address) {
        this.day = day;
        this.name = name;
        this.type = type;
        this.bookingDetails = bookingDetails;
        this.address = address;
    }

    public Accommodation() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
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
