package com.tripPlanner.demo.models;

import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
@Table(name = "activities")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "estimated_start_time")
    private LocalTime estimatedStartTime; // can be null

    @Column(name = "estimated_duration")
    private int estimatedDuration; // in minutes

    @Column(name = "activity_title")
    private String activityTitle;

    @Column
    private String notes;

    @ManyToOne
    @JoinColumn(name ="day_id")
    private Day day;

    public Activity(LocalTime estimatedStartTime, int estimatedDuration, String activityTitle, String notes, Day day) {
        this.estimatedStartTime = estimatedStartTime;
        this.estimatedDuration = estimatedDuration;
        this.activityTitle = activityTitle;
        this.notes = notes;
        this.day = day;
    }

    public Activity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }
}
