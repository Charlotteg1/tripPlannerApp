package com.tripPlanner.demo.models.dtos;

public class ItemConsumedDTO {

    private Long restaurantId;

    private String name;

    private Float rating;

    private String notes;

    public ItemConsumedDTO(Long restaurantId, String name, Float rating, String notes) {
        this.restaurantId = restaurantId;
        this.name = name;
        this.rating = rating;
        this.notes = notes;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
