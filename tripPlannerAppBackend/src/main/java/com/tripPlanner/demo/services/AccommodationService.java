package com.tripPlanner.demo.services;


import com.tripPlanner.demo.models.Accommodation;
import com.tripPlanner.demo.models.Day;
import com.tripPlanner.demo.models.dtos.AccommodationDTO;
import com.tripPlanner.demo.repostitories.AccommodationRepository;
import com.tripPlanner.demo.repostitories.DayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccommodationService {

//    add accommodation
//    delete
//    update

    @Autowired
    AccommodationRepository accommodationRepository;

    @Autowired
    DayRepository dayRepository;

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
    
}
