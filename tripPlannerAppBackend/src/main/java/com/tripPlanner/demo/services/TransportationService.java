package com.tripPlanner.demo.services;

import com.tripPlanner.demo.models.Transportation;
import com.tripPlanner.demo.models.Trip;
import com.tripPlanner.demo.models.dtos.TransportationDTO;
import com.tripPlanner.demo.repostitories.TransportationRepository;
import com.tripPlanner.demo.repostitories.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TransportationService {

//    add transportation
//    delete
//    update
//    view all transportation in a trip
//    view transportation happening on a particular day

    @Autowired
    TransportationRepository transportationRepository;

    @Autowired
    TripRepository tripRepository;

    public Transportation addTransportation(TransportationDTO transportationDTO){
        Trip trip = tripRepository.findById(transportationDTO.getTripId()).get();
        Transportation newTransportation = new Transportation(trip, transportationDTO.getDepartureDestination(), transportationDTO.getArrivalDestination(), transportationDTO.getDepartureTimeAndDate(),transportationDTO.getArrivalTimeAndDate(), transportationDTO.getMode());
        transportationRepository.save(newTransportation);
        return newTransportation;
    }

    public void deleteTransportation(Long id){
        transportationRepository.deleteById(id);
    }

    public Transportation updateTransportation(Long id, TransportationDTO transportationDTO){
        Transportation transportationToUpdate = transportationRepository.findById(id).get();

        if(transportationDTO.getDepartureDestination() != null){
            transportationToUpdate.setDepartureDestination(transportationDTO.getDepartureDestination());
        }else if(transportationDTO.getArrivalDestination() != null){
            transportationToUpdate.setArrivalDestination(transportationDTO.getArrivalDestination());
        }else if(transportationDTO.getDepartureTimeAndDate() != null){
            transportationToUpdate.setDepartureTimeAndDate(transportationDTO.getDepartureTimeAndDate());
        }else if(transportationDTO.getArrivalTimeAndDate() != null){
            transportationToUpdate.setArrivalTimeAndDate(transportationDTO.getArrivalTimeAndDate());
        }else if(transportationDTO.getMode() != null){
            transportationToUpdate.setMode(transportationDTO.getMode());
        }
        transportationRepository.save(transportationToUpdate);
        return transportationToUpdate;

    }

    public List<Transportation> getAllTransportationInTrip(Long tripId){
        Trip trip = tripRepository.findById(tripId).get();
        return trip.getTransportationList();
    }

//    public List<Transportation>  getAllTransportationOnDate(LocalDate chosenDate){
//
//
//    }

}
