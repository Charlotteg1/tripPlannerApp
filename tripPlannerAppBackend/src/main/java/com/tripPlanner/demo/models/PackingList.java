package com.tripPlanner.demo.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "packing_list")
public class PackingList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "packingList")
    private Trip trip;

    @OneToMany(mappedBy = "packing_list")
    private List<IndividualPackingList> individualPackingList;

    public PackingList(Trip trip, List<IndividualPackingList> individualPackingList) {
        this.trip = trip;
        this.individualPackingList = individualPackingList;
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

    public List<IndividualPackingList> getIndividualPackingLists() {
        return individualPackingList;
    }

    public void setIndividualPackingLists(List<IndividualPackingList> individualPackingList) {
        this.individualPackingList = individualPackingList;
    }

//    need to have a remove individual packing list and an add one.
}
