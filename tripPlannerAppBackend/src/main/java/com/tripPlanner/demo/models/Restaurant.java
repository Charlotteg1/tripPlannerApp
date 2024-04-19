package com.tripPlanner.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tripPlanner.demo.models.enums.Meal;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "restaurants")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "day_id")
    @JsonIgnoreProperties({"days"})
    private Day day;
    @Column
    private String name;

    @Enumerated(EnumType.STRING)
    private List<Meal> meal;

    @OneToMany(mappedBy = "restaurant")
    private List<ItemConsumed> itemsConsumed;

    @Column(name = "establishment_rating")
    private Float establishmentRating;

    @Column(name = "would_visit_again")
    private Boolean wouldVisitAgain; // may change to recommend

    public Restaurant(Day day, String name, List<Meal> meal, Float establishmentRating, Boolean wouldVisitAgain) {
        this.day = day;
        this.name = name;
        this.meal = meal;
        this.itemsConsumed = new ArrayList<>();
        this.establishmentRating = establishmentRating;
        this.wouldVisitAgain = wouldVisitAgain;
    }

    public Restaurant() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
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

    public List<ItemConsumed> getItemsConsumed() {
        return itemsConsumed;
    }

    public void setItemsConsumed(List<ItemConsumed> itemsConsumed) {
        this.itemsConsumed = itemsConsumed;
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
