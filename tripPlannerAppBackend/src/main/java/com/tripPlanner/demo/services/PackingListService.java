package com.tripPlanner.demo.services;


import com.tripPlanner.demo.models.PackingList;
import com.tripPlanner.demo.models.Trip;
import com.tripPlanner.demo.repostitories.PackingListRepository;
import com.tripPlanner.demo.repostitories.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PackingListService {

//    create new packing list
//    delete packing list
//    get all packing list for trip

    @Autowired
    PackingListRepository packingListRepository;

    @Autowired
    TripRepository tripRepository;

    public PackingList createNewList(Long tripId, String packingListName){
        Trip trip = tripRepository.findById(tripId).get();
        PackingList newList = new PackingList(trip, packingListName);
        packingListRepository.save(newList);
        return newList;
    }

    public List<PackingList> getListsForTrip(Long tripId){
        Trip trip = tripRepository.findById(tripId).get();
        return trip.getPackingList();
    }

    public void deletePackingList(Long id){
        packingListRepository.deleteById(id);
    }
}
