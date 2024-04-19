package com.tripPlanner.demo.controllers;


import com.tripPlanner.demo.models.Accommodation;
import com.tripPlanner.demo.models.Day;
import com.tripPlanner.demo.models.dtos.AccommodationDTO;
import com.tripPlanner.demo.services.AccommodationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping(name = "accommodation")
public class AccommodationController {

    @Autowired
    AccommodationService accommodationService;

    @PostMapping
    public ResponseEntity<Accommodation> addAccommodation(@RequestBody AccommodationDTO accommodationDTO){
        Accommodation newAccommodation = accommodationService.addAccommodation(accommodationDTO);
        if(newAccommodation !=null){
            return new ResponseEntity<>(newAccommodation , HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccommodation (@PathVariable Long id){
        accommodationService.deleteAccommodation(id);
        return new ResponseEntity<>(HttpStatus.GONE);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Accommodation> updateAccommodation(@PathVariable Long id , @RequestBody AccommodationDTO accommodationDTO) {
        Accommodation updateAccommodation = accommodationService.updateAccommodation(id, accommodationDTO);
        if (updateAccommodation != null) {
            return new ResponseEntity<>(updateAccommodation, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/day/{dayId}")
    public ResponseEntity<Accommodation> findAccommdationOnDay(@PathVariable Long dayId){
        Accommodation accommodation = accommodationService.getAccommodationByDay(dayId);
        if(accommodation !=null){
            return new ResponseEntity<>(accommodation, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/date/{date}")
    public ResponseEntity<Accommodation> findAccommodationOnDate(@PathVariable LocalDate date){
        Accommodation accommodation = accommodationService.getAccommodationByDate(date);
        if(accommodation !=null){
            return new ResponseEntity<>(accommodation, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/trip/{tripId}")
    public ResponseEntity<List<Accommodation>> findAccommodationsInTrip(@PathVariable Long tripId){
        List<Accommodation> accommodations = accommodationService.getAllAccommodationInTrip(tripId);
        if(accommodations !=null){
            return new ResponseEntity<>(accommodations, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

 }
