package com.tripPlanner.demo.services;

import com.tripPlanner.demo.models.*;
import com.tripPlanner.demo.models.dtos.RestaurantDTO;
import com.tripPlanner.demo.repostitories.DayRepository;
import com.tripPlanner.demo.repostitories.ItemConsumedRepository;
import com.tripPlanner.demo.repostitories.RestaurantRepository;
import com.tripPlanner.demo.repostitories.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    ItemConsumedRepository itemConsumedRepository;

    @Autowired
    DayRepository dayRepository;

    @Autowired
    TripRepository tripRepository;

    public Restaurant addRestaurant(RestaurantDTO restaurantDTO){
        Day day = dayRepository.findById(restaurantDTO.getDayId()).get();
        Restaurant addRestaurant = new Restaurant(day, restaurantDTO.getName(), restaurantDTO.getMeal(), restaurantDTO.getEstablishmentRating(), restaurantDTO.getWouldVisitAgain());
        restaurantRepository.save(addRestaurant);
        return addRestaurant;
    }

    public void deleteRestaurant(Long id){
        Restaurant restaurantToDelete = restaurantRepository.findById(id).get();
        List<ItemConsumed> items = restaurantToDelete.getItemsConsumed();

        for (ItemConsumed item : items) {
            itemConsumedRepository.delete(item);
        }
        restaurantRepository.deleteById(id);
    }

    public Restaurant updateRestaurant(Long restaurantId, RestaurantDTO restaurantDTO){
        Restaurant restaurantToUpdate = restaurantRepository.findById(restaurantId).get();

       if(restaurantDTO.getName() != null){
           restaurantToUpdate.setName(restaurantDTO.getName());
       }else if(restaurantDTO.getMeal() != null){
           restaurantToUpdate.setMeal(restaurantDTO.getMeal());
       }else if(restaurantDTO.getEstablishmentRating() != null){
           restaurantToUpdate.setEstablishmentRating(restaurantDTO.getEstablishmentRating());
        }else if(restaurantDTO.getWouldVisitAgain() != null){
           restaurantToUpdate.setWouldVisitAgain(restaurantDTO.getWouldVisitAgain());
        }
        restaurantRepository.save(restaurantToUpdate);
        return restaurantToUpdate;
    }

    public List<Restaurant> getRestaurantByDay(Long dayId){
        Day day = dayRepository.findById(dayId).get();
        return day.getRestaurants();
    }

    public List<Restaurant> getAllRestaurantInTrip(Long tripId){
        Trip trip = tripRepository.findById(tripId).get();
        List<Restaurant> restaurants = new ArrayList<>();
        for(Day day: trip.getDays()){
            for(Restaurant restaurant: day.getRestaurants()) {
                restaurants.add(restaurant);
            }
        }
        return restaurants;
    }

    public Restaurant getRestaurantById(Long id){
        return restaurantRepository.findById(id).get();
    }


    

}
