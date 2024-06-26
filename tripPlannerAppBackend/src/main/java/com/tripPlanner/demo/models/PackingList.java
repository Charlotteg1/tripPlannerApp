package com.tripPlanner.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "packing_lists")
public class PackingList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "trip_id")
    private Trip trip;

    @Column(name = "list_name")
    private String listName;

    @OneToMany(mappedBy = "packingList")
    private List<PackingListItem> items;

    public PackingList(Trip trip, String listName) {
        this.trip = trip;
        this.listName = listName;
        this.items = new ArrayList<>();
    }

    public PackingList() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public List<PackingListItem> getItems() {
        return items;
    }

    public void setItems(List<PackingListItem> items) {
        this.items = items;
    }
}
