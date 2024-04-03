package tripPlanner.com.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Transportation {

//    -
//            - id
//    - trip id
//    - date
//    - time of  departure
//    - time of arrival
//    - mode of travel

    private Long id;

    private Long tripId; // may be more wise to change to dayId, relating to day by day

    private LocalDateTime departureTimeAndDate;

    private LocalDateTime arrivalTimeAndDate;

    private ModeOfTravel mode;
}
