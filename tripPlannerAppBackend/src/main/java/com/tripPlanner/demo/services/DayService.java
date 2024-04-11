package com.tripPlanner.demo.services;

import com.tripPlanner.demo.models.Day;
import com.tripPlanner.demo.models.Trip;
import com.tripPlanner.demo.models.User;
import com.tripPlanner.demo.repostitories.DayRepository;
import com.tripPlanner.demo.repostitories.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DayService {
//    get all days in a trip
//    get day by id
//    get day by date
//    updateDay/edit
//    delete day

    @Autowired
    DayRepository dayRepository;

    @Autowired
    TripRepository tripRepository;

    public void generateDaysForTrip(Trip trip){

        LocalDate startDate = trip.getTripStartDate();
        LocalDate endDate = trip.getTripEndDate();

        for(LocalDate date = startDate; !date.isAfter(endDate) ; date = date.plusDays(1)){
            Day newDay = new Day(trip,trip.getDestination(),date,null);
            dayRepository.save(newDay);
        }
    }

    public List<Day> getAllTripDays(Long tripId){
        Trip trip = tripRepository.findById(tripId).get();
        List<Day> daysIntrip = trip.getDays();
        return daysIntrip;
    }

    public Day updateDay(Long id, String destination) {
        Day day = dayRepository.findById(id).get();
        if(destination != null){
            day.setDestination(destination);
        }
        return dayRepository.save(day);
    }
}
