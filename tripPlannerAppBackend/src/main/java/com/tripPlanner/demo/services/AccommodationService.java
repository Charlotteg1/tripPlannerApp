package com.tripPlanner.demo.services;


import com.tripPlanner.demo.models.Accommodation;
import com.tripPlanner.demo.models.Day;
import com.tripPlanner.demo.models.Transportation;
import com.tripPlanner.demo.models.Trip;
import com.tripPlanner.demo.models.dtos.AccommodationDTO;
import com.tripPlanner.demo.repostitories.AccommodationRepository;
import com.tripPlanner.demo.repostitories.DayRepository;
import com.tripPlanner.demo.repostitories.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class AccommodationService {

//    add accommodation
//    delete
//    update
//    view Accommodation by day id
//    view accommodation by date
//    view all accommodation in trip

    @Autowired
    AccommodationRepository accommodationRepository;

    @Autowired
    DayRepository dayRepository;

    @Autowired
    TripRepository tripRepository;

    public Accommodation addAccommodation(AccommodationDTO accommodationDTO){
        List<Day> days = new ArrayList<>();
        for( Long dayId :accommodationDTO.getDayIds() ){
            Day day = dayRepository.findById(dayId).get();
            days.add(day);
        }
        Accommodation newAccommodation = new Accommodation(days, accommodationDTO.getName(), accommodationDTO.getType(), accommodationDTO.getBookingDetails(), accommodationDTO.getAddress());
        return accommodationRepository.save(newAccommodation);

//       need to check that is added on the Day side
    }

    public void deleteAccommodation(Long accommodationId){
        accommodationRepository.deleteById(accommodationId);
    }

    public Accommodation updateAccommodation(Long accommodationId, AccommodationDTO accommodationDTO){
        Accommodation accommodationToUpdate = accommodationRepository.findById(accommodationId).get();

        if(accommodationDTO.getDayIds() != null){
            List<Day> days = new ArrayList<>();
            for (Long dayId : accommodationDTO.getDayIds()) {
                Day day = dayRepository.findById(dayId).get();
                days.add(day);
            }
            accommodationToUpdate.setDays(days);
        }else if(accommodationDTO.getName() != null){
            accommodationToUpdate.setName(accommodationDTO.getName());
        }else if(accommodationDTO.getType() != null){
            accommodationToUpdate.setType(accommodationDTO.getType());
        }else if(accommodationDTO.getBookingDetails() != null){
            accommodationToUpdate.setBookingDetails(accommodationDTO.getBookingDetails());
        }else if(accommodationDTO.getAddress() != null){
            accommodationToUpdate.setAddress(accommodationDTO.getAddress());
        }
        accommodationRepository.save(accommodationToUpdate);
        return accommodationToUpdate;
    }

    public Accommodation getAccommodationByDay(Long dayId){
        Day day = dayRepository.findById(dayId).get();
        return day.getAccommodation();
    }

    public Accommodation getAccommodationByDate(LocalDate date){
//        will be the accommodation for that night
        Day day = dayRepository.findByDate(date);
        return day.getAccommodation();
    }

    public List<Accommodation> getAllAccommodationInTrip(Long tripId){
        Trip trip = tripRepository.findById(tripId).get();
        List<Accommodation> stays = new ArrayList<>();
        for(Day day: trip.getDays()){
            stays.add(day.getAccommodation());
        }
        return stays;
    }

}
