package com.tripPlanner.demo.controllers;

import com.tripPlanner.demo.models.Day;
import com.tripPlanner.demo.services.DayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/days")
public class DayController {

    @Autowired
    DayService dayService;


    @GetMapping("/trip/{tripId}")
    public ResponseEntity<List<Day>> findDaysInTrip(@PathVariable Long tripId){
        List<Day> findDays = dayService.getAllTripDays(tripId);
        if(findDays!=null){
            return new ResponseEntity<>(findDays, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Day> editDay(@PathVariable Long id, @RequestBody Map<String, String> requestBody){
        String destination = requestBody.get("destination");
        Day updateDay = dayService.updateDay(id, destination);
        if(updateDay!=null){
            return new ResponseEntity<>(updateDay, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
}
