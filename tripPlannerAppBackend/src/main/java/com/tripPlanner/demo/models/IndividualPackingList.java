package com.tripPlanner.demo.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "individual_packing_list")
public class IndividualPackingList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "packing_list_id")
    private PackingList packingList;

    @Column(name = "list_name")
    private String listName;

    @OneToMany(mappedBy = "individual_packing_list")
    private List<PackingListItem> items;

    public IndividualPackingList(PackingList packingList, String listName, List<PackingListItem> items) {
        this.packingList = packingList;
        this.listName = listName;
        this.items = items;
    }

    public IndividualPackingList() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PackingList getPackingList() {
        return packingList;
    }

    public void setPackingList(PackingList packingList) {
        this.packingList = packingList;
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
