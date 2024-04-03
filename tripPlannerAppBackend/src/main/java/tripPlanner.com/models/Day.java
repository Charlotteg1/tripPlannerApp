package tripPlanner.com.models;

import java.time.LocalDate;
import java.util.List;

public class Day {

    // Properties
    private Long id;
    
    private Long tripId;

    private LocalDate date;

    private List<Activities> activities;

    private List<Restaurants> restaurants;

    public Day(Long tripId, LocalDate date, List<Activities> activities, List<Restaurants> restaurants) {
        this.tripId = tripId;
        this.date = date;
        this.activities = activities;
        this.restaurants = restaurants;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTripId() {
        return tripId;
    }

    public void setTripId(Long tripId) {
        this.tripId = tripId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<Activities> getActivities() {
        return activities;
    }

    public void setActivities(List<Activities> activities) {
        this.activities = activities;
    }

    public List<Restaurants> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<Restaurants> restaurants) {
        this.restaurants = restaurants;
    }
}
