package com.tripPlanner.demo.controllers;

import com.tripPlanner.demo.models.Transportation;
import com.tripPlanner.demo.models.dtos.TransportationDTO;
import com.tripPlanner.demo.services.TransportationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping(name = "transportation")
public class TransportationController {

    @Autowired
    TransportationService transportationService;

    @PostMapping
    public ResponseEntity<Transportation> addTransportation(@RequestBody TransportationDTO transportationDTO){
        Transportation transportation = transportationService.addTransportation(transportationDTO);
        return new ResponseEntity<>(transportation, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJourney(@PathVariable Long id){
        transportationService.deleteTransportation(id);
        return new ResponseEntity<>(HttpStatus.GONE);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Transportation> updateTransportation(@PathVariable Long id, @RequestBody TransportationDTO transportationDTO){
        Transportation updateTransportation = transportationService.updateTransportation(id, transportationDTO);
        return new ResponseEntity<>(updateTransportation, HttpStatus.CREATED);
    }

    @GetMapping("/trip/{tripId}")
    public ResponseEntity<List<Transportation>> getAllTransportationInTrip(@PathVariable Long tripId){
        List<Transportation> journeys = transportationService.getAllTransportationInTrip(tripId);
        if(journeys != null){
            return new ResponseEntity<>(journeys, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

//    @GetMapping("/date/{date}")
//    public ResponseEntity<List<Transportation>> getByOnDate(@PathVariable LocalDate date){
//        List<Transportation> journeys = transportationService.getAllTransportationOnDate(date);
//        if(journeys != null){
//            return new ResponseEntity<>(journeys, HttpStatus.FOUND);
//        }else{
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
}
