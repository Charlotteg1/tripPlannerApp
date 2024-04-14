package com.tripPlanner.demo.controllers;

import com.tripPlanner.demo.models.PackingList;
import com.tripPlanner.demo.services.PackingListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/packingLists")
public class PackingListController {

    @Autowired
    PackingListService packingListService;

//    createNewList
    @PostMapping("/{tripId}")
    public ResponseEntity<PackingList> createNewPackingList(@PathVariable Long tripId, @RequestBody Map<String, String> requestBody){
        String listName = requestBody.get("listName");
        PackingList newPackingList = packingListService.createNewList(tripId, listName );
        if(newPackingList!=null){
            return new ResponseEntity<>(newPackingList, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/trip/{tripId}")
    public ResponseEntity<List<PackingList>> getTripPackingList(@PathVariable Long tripId){
        List<PackingList> packingLists = packingListService.getListsForTrip(tripId);
        if(packingLists!=null){
            return new ResponseEntity<>(packingLists, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }


    @DeleteMapping("/deleteList/{id}")
    public ResponseEntity<Void> deleteList(@PathVariable Long id){
        packingListService.deletePackingList(id);
        return new ResponseEntity<>(HttpStatus.GONE);
    }


}
