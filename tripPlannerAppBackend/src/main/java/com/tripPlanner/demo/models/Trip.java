package com.tripPlanner.demo.models;

import com.tripPlanner.demo.models.enums.Climate;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "trips")
public class Trip {

    //Properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column
    private String destination;

    @Column(name = "trip_start_date")
    private LocalDate tripStartDate;

    @Column(name = "trip_end_date")
    private LocalDate tripEndDate;

    @Enumerated(EnumType.STRING)
    private Climate climate;

//  could later add business or leisure option, ie private boolean businessTrip

    @OneToMany(mappedBy = "trip")
    private List<PackingList> packingList;

//  is in trip (not in the day) as the transportation/ journey start date and end date may span across days
    @OneToMany(mappedBy = "trip")
    private List<Transportation> transportationList;

    @OneToMany(mappedBy = "trip")
    private List<Day> days;

    //Constructor


    public Trip(User user, String destination, LocalDate tripStartDate, LocalDate tripEndDate, Climate climate) {
        this.user = user;
        this.destination = destination;
        this.tripStartDate = tripStartDate;
        this.tripEndDate = tripEndDate;
        this.climate = climate;
        this.packingList = new ArrayList<>();
        this.transportationList = new ArrayList<>();
        this.days = new ArrayList<>();
    }

    //Default Constructor
    public Trip() {
    }

    //Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public List<PackingList> getPackingList() {
        return packingList;
    }

    public void setPackingList(List<PackingList> packingList) {
        this.packingList = packingList;
    }


    public List<Transportation> getTransportationList() {
        return transportationList;
    }

    public void setTransportationList(List<Transportation> transportationList) {
        this.transportationList = transportationList;
    }

    public List<Day> getDays() {
        return days;
    }

    public void setDays(List<Day> days) {
        this.days = days;
    }
}
