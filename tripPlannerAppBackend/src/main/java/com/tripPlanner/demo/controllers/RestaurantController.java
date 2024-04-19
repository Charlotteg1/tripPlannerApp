package com.tripPlanner.demo.controllers;


import com.tripPlanner.demo.models.Activity;
import com.tripPlanner.demo.models.Restaurant;
import com.tripPlanner.demo.models.dtos.ActivityDTO;
import com.tripPlanner.demo.models.dtos.RestaurantDTO;
import com.tripPlanner.demo.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    @PostMapping
    public ResponseEntity<Restaurant> addRestaurant(@RequestBody RestaurantDTO restaurantDTO){
        Restaurant addRestaurant = restaurantService.addRestaurant(restaurantDTO);
        if(addRestaurant !=null){
            return new ResponseEntity<>(addRestaurant, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRestaurant (@PathVariable Long id){
        restaurantService.deleteRestaurant(id);
        return new ResponseEntity<>(HttpStatus.GONE);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Restaurant> updateRestaurant(@PathVariable Long id , @RequestBody RestaurantDTO restaurantDTO) {
        Restaurant updateRestaurant = restaurantService.updateRestaurant(id, restaurantDTO);
        if (updateRestaurant != null) {
            return new ResponseEntity<>(updateRestaurant, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/day/{dayId}")
    public ResponseEntity<List<Restaurant>> findRestaurantsOnDay(@PathVariable Long dayId){
        List<Restaurant> restaurants = restaurantService.getRestaurantByDay(dayId);
        if(restaurants !=null){
            return new ResponseEntity<>(restaurants, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/trip/{tripId}")
    public ResponseEntity<List<Restaurant>> findAllRestaurantsInTrip(@PathVariable Long tripId){
        List<Restaurant> restaurants = restaurantService.getAllRestaurantsInTrip(tripId);
        if(restaurants !=null){
            return new ResponseEntity<>(restaurants, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> findRestaurantById(@PathVariable Long id){
        Restaurant restaurant = restaurantService.getRestaurantById(id);
        if(restaurant !=null){
            return new ResponseEntity<>(restaurant, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }


}
