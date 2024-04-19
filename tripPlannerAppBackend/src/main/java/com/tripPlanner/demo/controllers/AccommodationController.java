package com.tripPlanner.demo.controllers;


import com.tripPlanner.demo.models.Accommodation;
import com.tripPlanner.demo.models.dtos.AccommodationDTO;
import com.tripPlanner.demo.services.AccommodationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
 }
