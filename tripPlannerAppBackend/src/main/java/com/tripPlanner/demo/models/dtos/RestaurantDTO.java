package com.tripPlanner.demo.models.dtos;

import com.tripPlanner.demo.models.enums.Meal;


import java.util.List;

public class RestaurantDTO {

    private Long dayId;

    private String name;

    private List<Meal> meal;

//    private List<ItemConsumed> itemsConsumed;

    private Float establishmentRating;

    private Boolean wouldVisitAgain;

    public RestaurantDTO(Long dayId, String name, List<Meal> meal, Float establishmentRating, Boolean wouldVisitAgain) {
        this.dayId = dayId;
        this.name = name;
        this.meal = meal;
        this.establishmentRating = establishmentRating;
        this.wouldVisitAgain = wouldVisitAgain;
    }

    public Long getDayId() {
        return dayId;
    }

    public void setDayId(Long dayId) {
        this.dayId = dayId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Meal> getMeal() {
        return meal;
    }

    public void setMeal(List<Meal> meal) {
        this.meal = meal;
    }

    public Float getEstablishmentRating() {
        return establishmentRating;
    }

    public void setEstablishmentRating(Float establishmentRating) {
        this.establishmentRating = establishmentRating;
    }

    public Boolean getWouldVisitAgain() {
        return wouldVisitAgain;
    }

    public void setWouldVisitAgain(Boolean wouldVisitAgain) {
        this.wouldVisitAgain = wouldVisitAgain;
    }
}
