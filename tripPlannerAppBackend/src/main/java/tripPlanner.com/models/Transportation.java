package tripPlanner.com.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Transportation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "trip_id")
    @ManyToOne
    @JsonIgnoreProperties({"trips"})
    private Long tripId; // may be more wise to change to dayId, relating to day by day

    @Column(name = "departure_time_and_date")
    private LocalDateTime departureTimeAndDate;

    @Column(name = "arrival_time_and_date")
    private LocalDateTime arrivalTimeAndDate;

    @Column(name = "mode_of_travel")
    @Enumerated
    private ModeOfTravel mode;

    public Transportation(Long tripId, LocalDateTime departureTimeAndDate, LocalDateTime arrivalTimeAndDate, ModeOfTravel mode) {
        this.tripId = tripId;
        this.departureTimeAndDate = departureTimeAndDate;
        this.arrivalTimeAndDate = arrivalTimeAndDate;
        this.mode = mode;
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

    public ModeOfTravel getMode() {
        return mode;
    }

    public void setMode(ModeOfTravel mode) {
        this.mode = mode;
    }
}
