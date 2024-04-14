package com.tripPlanner.demo.controllers;

import com.tripPlanner.demo.models.PackingList;
import com.tripPlanner.demo.models.PackingListItem;
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

    @GetMapping("/itemsInList/{listId}")
    public ResponseEntity<List<PackingListItem>> itemsInPackingList(@PathVariable Long listId){
        List<PackingListItem> items = packingListService.itemsInList(listId);
        if(items!=null){
            return new ResponseEntity<>(items, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping("/addItem/{listId}")
    public ResponseEntity<PackingList> addItemToList(@PathVariable Long listId, @RequestBody Map<String, String> requestBody){
        String itemName = requestBody.get("itemName");
        PackingList packingList = packingListService.addNewItem(listId, itemName);
        if(packingList!=null){
            return new ResponseEntity<>(packingList, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }


    @DeleteMapping("/deleteItem/{itemId}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long itemId){
        packingListService.deleteItem(itemId);
        return new ResponseEntity<>(HttpStatus.GONE);
    }

    @PostMapping("/updateItem/{itemId}")
    public ResponseEntity<PackingListItem> updateItem(@PathVariable Long itemId){
        PackingListItem updateItem = packingListService.updateItem(itemId);
        if(updateItem!=null){
            return new ResponseEntity<>(updateItem, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }



}
