package com.tripPlanner.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDate;
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

    @Column(name = "trip_start_date")
    private LocalDate tripStartDate;

    @Column(name = "trip_end_date")
    private LocalDate tripEndDate;

    @Enumerated(EnumType.STRING)
    private Climate climate;

    @OneToOne(mappedBy = "trip")
    private PackingList packingList;

    @OneToMany(mappedBy = "trip")
    @JsonIgnoreProperties("trips")
    private List<Transportation> transportationList;

    @OneToMany(mappedBy = "trip")
    @JsonIgnoreProperties({"trips"})
    private List<Day> days;

    //Constructor
    public Trip(User user, LocalDate tripStartDate, LocalDate tripEndDate, Climate climate, List<Transportation> transportationList ) {
        this.user = user;
        this.tripStartDate = tripStartDate;
        this.tripEndDate = tripEndDate;
        this.climate = climate;
        this.packingList=null;
        this.transportationList= transportationList;
    }


    //Default Constructor
    public Trip() {
    }

    //Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long Id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public PackingList getPackingList() {
        return packingList;
    }

    public void setPackingList(PackingList packingList) {
        this.packingList = packingList;
    }

    public List<Transportation> getTransportationList() {
        return transportationList;
    }

    public void setTransportationList(List<Transportation> transportationList) {
        this.transportationList = transportationList;
    }
}
