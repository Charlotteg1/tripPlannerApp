package com.tripPlanner.demo.services;

import com.tripPlanner.demo.models.Day;
import com.tripPlanner.demo.models.Trip;
import com.tripPlanner.demo.repostitories.DayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class DayService {

    @Autowired
    DayRepository dayRepository;

    public void generateDaysForTrip(Trip trip){

        LocalDate startDate = trip.getTripStartDate();
        LocalDate endDate = trip.getTripEndDate();

        for(LocalDate date = startDate; !date.isAfter(endDate) ; date = date.plusDays(1)){
            Day newDay = new Day(trip,trip.getDestination(),date,null);
            dayRepository.save(newDay);
        }
    }
}
