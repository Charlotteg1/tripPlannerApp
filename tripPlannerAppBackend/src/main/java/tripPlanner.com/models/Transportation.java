package tripPlanner.com.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Transportation {


    private Long id;

    private Long tripId; // may be more wise to change to dayId, relating to day by day

    private LocalDateTime departureTimeAndDate;

    private LocalDateTime arrivalTimeAndDate;

    private ModeOfTravel mode;
}
