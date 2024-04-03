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
//    - arrival(true or false indicating travelling there and first day)
//- Departure (true or false)
//- activities
//- Restaurants  plans
}
