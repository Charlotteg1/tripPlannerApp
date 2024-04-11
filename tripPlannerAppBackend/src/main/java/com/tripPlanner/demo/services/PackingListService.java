package com.tripPlanner.demo.services;


import com.tripPlanner.demo.models.PackingList;
import com.tripPlanner.demo.models.PackingListItem;
import com.tripPlanner.demo.models.Trip;
import com.tripPlanner.demo.repostitories.PackingListItemRepository;
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
//    add packing list item
//    delete packing list item
//    update item in packinglist (mark as packed)

    @Autowired
    PackingListRepository packingListRepository;

    @Autowired
    TripRepository tripRepository;

    @Autowired
    PackingListItemRepository packingListItemRepository;

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

    public PackingList addNewItem(Long packingListId, String itemName){
        PackingList packingList= packingListRepository.findById(packingListId).get();
        PackingListItem newItem = new PackingListItem(packingList,false, itemName);
        packingListItemRepository.save(newItem);
        return packingList;
    }

    public void deleteItem(Long itemId){
        packingListItemRepository.deleteById(itemId);
    }

//    may later want to add option to alter itemname, but will just switch packed (boolen) for now
    public PackingListItem updateItem(Long itemId){
        PackingListItem itemToUpdate = packingListItemRepository.findById(itemId).get();
        itemToUpdate.setPacked(!itemToUpdate.isPacked());
        packingListItemRepository.save(itemToUpdate);
        return itemToUpdate;
    }
    
}
