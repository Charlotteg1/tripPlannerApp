package com.tripPlanner.demo.controllers;

import com.tripPlanner.demo.models.Accommodation;
import com.tripPlanner.demo.models.Activity;
import com.tripPlanner.demo.models.dtos.ActivityDTO;
import com.tripPlanner.demo.services.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("activity")
public class ActivityController {


    @Autowired
    ActivityService activityService;

    @PostMapping
    public ResponseEntity<Activity> addActivity(@RequestBody ActivityDTO activityDTO){
        Activity newActivity = activityService.addActivity(activityDTO);
        if(newActivity !=null){
            return new ResponseEntity<>(newActivity, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteActivity (@PathVariable Long id){
        activityService.deleteActivity(id);
        return new ResponseEntity<>(HttpStatus.GONE);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Activity> updateActivity(@PathVariable Long id , @RequestBody ActivityDTO activityDTO) {
        Activity updateActivity = activityService.updateActivity(id, activityDTO);
        if (updateActivity != null) {
            return new ResponseEntity<>(updateActivity, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/day/{dayId}")
    public ResponseEntity<List<Activity>> findActivitiesOnDay(@PathVariable Long dayId){
        List<Activity> activities = activityService.getActivityByDay(dayId);
        if(activities !=null){
            return new ResponseEntity<>(activities, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/trip/{tripId}")
    public ResponseEntity<List<Activity>> findActivitiesInTrip(@PathVariable Long tripId){
        List<Activity> activities = activityService.getAllActivityInTrip(tripId);
        if(activities !=null){
            return new ResponseEntity<>(activities, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
