package com.tripPlanner.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "items_consumed")
public class ItemConsumed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @Column
    private String name;

    @Column
    private Float rating;

    @Column
    private String notes;

    // in future enable a picture to be stored of dish eaten (eg)

    public ItemConsumed(Restaurant restaurant, String name, Float rating, String notes) {
        this.restaurant = restaurant;
        this.name = name;
        this.rating = rating;
        this.notes = notes;
    }

    public ItemConsumed() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
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
