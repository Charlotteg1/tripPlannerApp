package com.tripPlanner.demo.controllers;

import com.tripPlanner.demo.models.Trip;
import com.tripPlanner.demo.models.dtos.TripDTO;
import com.tripPlanner.demo.services.DayService;
import com.tripPlanner.demo.services.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/trip")
public class TripController {

    @Autowired
    TripService tripService;

    @Autowired
    DayService dayService;

    @GetMapping("/{id}")
    public ResponseEntity<Trip> findTripById(@PathVariable Long id){
        Trip findTrip = tripService.getTripById(id);
        if(findTrip != null){
            return new ResponseEntity<>(findTrip, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Trip>> findTripsByUser(@PathVariable Long userId){
        List<Trip> findTrips = tripService.getAllUsersTrips(userId);
        if(findTrips!=null){
            return new ResponseEntity<>(findTrips, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping("/addTrip")
    public ResponseEntity<Trip> addTrip(@RequestBody TripDTO tripDTO){
        Trip newTrip = tripService.addTrip(tripDTO);
        if(newTrip!=null){
            dayService.generateDaysForTrip(newTrip);
            return new ResponseEntity<>(newTrip, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @PutMapping("/updateTrip/{id}")
    public ResponseEntity<Trip> updateTrip(@PathVariable Long id, @RequestBody TripDTO tripDTO){
        Trip updateTrip = tripService.updateTrip(id, tripDTO);
        return new ResponseEntity<>(updateTrip, HttpStatus.OK);
    }

}
