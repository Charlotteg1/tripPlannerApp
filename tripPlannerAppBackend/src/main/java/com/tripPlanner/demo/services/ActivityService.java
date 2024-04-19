package com.tripPlanner.demo.services;

import com.tripPlanner.demo.models.Activity;
import com.tripPlanner.demo.models.Day;
import com.tripPlanner.demo.models.Trip;
import com.tripPlanner.demo.models.dtos.ActivityDTO;
import com.tripPlanner.demo.repostitories.ActivityRepository;
import com.tripPlanner.demo.repostitories.DayRepository;
import com.tripPlanner.demo.repostitories.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ActivityService {

    @Autowired
    ActivityRepository activityRepository;

    @Autowired
    DayRepository dayRepository;

    @Autowired
    TripRepository tripRepository;

    public Activity addActivity(ActivityDTO activityDTO){
        Day day = dayRepository.findById(activityDTO.getDayId()).get();
        Activity newActivity = new Activity(activityDTO.getEstimatedStartTime(), activityDTO.getEstimatedDuration(), activityDTO.getActivityTitle(), activityDTO.getNotes(), day);
        activityRepository.save(newActivity);
        return newActivity;
    }

    public void deleteActivity(Long id){
        activityRepository.deleteById(id);
    }

    public Activity updateActivity(Long id, ActivityDTO activityDTO){
        Activity activityToUpdate = activityRepository.findById(id).get();

        if(activityDTO.getEstimatedStartTime() != null){
            activityToUpdate.setEstimatedStartTime(activityDTO.getEstimatedStartTime());
        }else if(activityDTO.getEstimatedDuration() != 0){
            activityToUpdate.setEstimatedDuration(activityDTO.getEstimatedDuration());
        }else if(activityDTO.getActivityTitle() != null){
            activityToUpdate.setActivityTitle(activityDTO.getActivityTitle());
        }else if(activityDTO.getNotes() != null){
            activityToUpdate.setNotes(activityDTO.getNotes());
        }else if(activityDTO.getDayId() != null){
            Day day = dayRepository.findById(activityDTO.getDayId()).get();
            activityToUpdate.setDay(day);
        }
        activityRepository.save(activityToUpdate);
        return activityToUpdate;

    }

    public List<Activity> getActivityByDay(Long dayId){
        Day day = dayRepository.findById(dayId).get();
        return day.getActivities();
    }

    public List<Activity> getAllActivityInTrip(Long tripId){
        Trip trip = tripRepository.findById(tripId).get();
        List<Activity> activities = new ArrayList<>();
        for(Day day: trip.getDays()){
            for(Activity activity: day.getActivities()) {
                activities.add(activity);
            }
        }
        return activities;
    }
}
