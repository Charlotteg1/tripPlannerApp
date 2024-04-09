package com.tripPlanner.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "days")
public class Day {

    // Properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "trip_id")
    private Trip trip;

    @Column
    private LocalDate date;

    @OneToMany(mappedBy = "day")
    private List<Activity> activities;

    // may later change to, many to many as can go to the same restaurant/food place numerous times in a trip
    @OneToMany(mappedBy = "day")
    private List<Restaurant> restaurants;

    public Day(Trip trip, LocalDate date, List<Activity> activities, List<Restaurant> restaurants) {
        this.trip = trip;
        this.date = date;
        this.activities = activities;
        this.restaurants = restaurants;
    }

    public Day() {
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<Activity> getActivity() {
        return activities;
    }

    public void setActivity(List<Activity> activities) {
        this.activities = activities;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }
}
