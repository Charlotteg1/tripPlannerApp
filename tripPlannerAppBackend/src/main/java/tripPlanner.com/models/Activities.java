package tripPlanner.com.models;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Activities {

    private LocalTime estimatedStartTime; // can be null
    private int estimatedDuration; // in minutes
    private String activityTitle;
    private String notes;

    public Activities(LocalTime estimatedStartTime, int estimatedDuration, String activityTitle, String notes) {
        this.estimatedStartTime = estimatedStartTime;
        this.estimatedDuration = estimatedDuration;
        this.activityTitle = activityTitle;
        this.notes = notes;
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
}
