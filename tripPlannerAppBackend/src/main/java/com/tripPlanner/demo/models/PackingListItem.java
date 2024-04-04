package com.tripPlanner.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "packing_list_item")
public class PackingListItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "individual_packing_list_id")
    private IndividualPackingList individualPackingList;

    @Column
    private boolean packed;

    @Column(name = "item_name")
    private String itemName;

    public PackingListItem(IndividualPackingList individualPackingList, boolean packed, String itemName) {
        this.individualPackingList = individualPackingList;
        this.packed = packed;
        this.itemName = itemName;
    }

    public PackingListItem() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public IndividualPackingList getIndividualPackingList() {
        return individualPackingList;
    }

    public void setIndividualPackingList(IndividualPackingList individualPackingList) {
        this.individualPackingList = individualPackingList;
    }

    public boolean isPacked() {
        return packed;
    }

    public void setPacked(boolean packed) {
        this.packed = packed;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
