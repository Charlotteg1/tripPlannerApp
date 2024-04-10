package com.tripPlanner.demo.services;

import com.tripPlanner.demo.models.Trip;
import com.tripPlanner.demo.models.User;
import com.tripPlanner.demo.models.dtos.TripDTO;
import com.tripPlanner.demo.repostitories.TripRepository;
import com.tripPlanner.demo.repostitories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripService {
//    add new trip
//    update trip
//    find trip by id
//    get all trips (belonging to user)

    @Autowired
    TripRepository tripRepository;

    @Autowired
    UserRepository userRepository;

    public Trip getTripById(Long id){
        Trip tripToFind = tripRepository.findById(id).get();
        if(tripToFind != null){
            return tripToFind;
        }else{
            return null;
        }
    }

    public List<Trip> getAllUsersTrips(Long userId){
        User user = userRepository.findById(userId).get();
        List<Trip> userTrips = user.getTrips();
        return userTrips;
    }

    public Trip addTrip(TripDTO tripDTO) {
//        need to check that no trips overlap (To Do Later)
//        would need to get all users trips check start date for new trip is before any start day for prev trips (saved)
//        and that it is after any end dates for prev trips.
//        same for end date of trip
        User user = userRepository.findById(tripDTO.getUserId()).get();
            Trip trip = new Trip(user, tripDTO.getDestination(), tripDTO.getTripStartDate(), tripDTO.getTripEndDate(),tripDTO.getClimate());
            return tripRepository.save(trip);
    }

    public Trip updateTrip(Long tripId, TripDTO tripDTO){
        Trip tripToUpdate = tripRepository.findById(tripId).get();

        if(tripDTO.getDestination() != null){
            tripToUpdate.setDestination(tripDTO.getDestination());
        }else if (tripDTO.getTripStartDate() != null) {
            tripToUpdate.setTripStartDate(tripDTO.getTripStartDate());
        }else if (tripDTO.getTripEndDate() != null) {
            tripToUpdate.setTripEndDate(tripDTO.getTripEndDate());
        }else if (tripDTO.getClimate() != null) {
            tripToUpdate.setClimate(tripDTO.getClimate());
        }
        return tripRepository.save(tripToUpdate);
    }

}
