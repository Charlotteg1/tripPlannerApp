package tripPlanner.com.models;

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

    @Column(name = "trip_id")
    @ManyToOne
    @JsonIgnoreProperties({"trips"})
    private Long tripId;

    @Column
    private LocalDate date;

    @OneToMany(mappedBy = "day")
    @JsonIgnoreProperties({"days"})
    private List<Activity> activities;

    @OneToMany(mappedBy = "day")
    @JsonIgnoreProperties({"days"})
    private List<Restaurant> restaurants;

    public Day(Long tripId, LocalDate date, List<Activity> activities, List<Restaurant> restaurants) {
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
