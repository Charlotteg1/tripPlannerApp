package com.tripPlanner.demo.models.dtos;

import java.time.LocalTime;

public class ActivityDTO {

    private LocalTime estimatedStartTime; // can be null

    private int estimatedDuration; // in minutes

    private String activityTitle;


    private String notes;

    private Long dayId;

    public ActivityDTO(LocalTime estimatedStartTime, int estimatedDuration, String activityTitle, String notes, Long dayId) {
        this.estimatedStartTime = estimatedStartTime;
        this.estimatedDuration = estimatedDuration;
        this.activityTitle = activityTitle;
        this.notes = notes;
        this.dayId = dayId;
    }

    public LocalTime getEstimatedStartTime() {
        return estimatedStartTime;
    }

    public void setEstimatedStartTime(LocalTime estimatedStartTime) {
        this.estimatedStartTime = estimatedStartTime;
    }

    public int getEstimatedDuration() {
        return estimatedDuration;
    }

    public void setEstimatedDuration(int estimatedDuration) {
        this.estimatedDuration = estimatedDuration;
    }

    public String getActivityTitle() {
        return activityTitle;
    }

    public void setActivityTitle(String activityTitle) {
        this.activityTitle = activityTitle;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Long getDayId() {
        return dayId;
    }

    public void setDayId(Long dayId) {
        this.dayId = dayId;
    }
}

