package com.tripPlanner.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "list_items")
public class PackingListItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "individual_packing_list_id")
    private PackingList packingList;

    @Column
    private boolean packed;

    @Column(name = "item_name")
    private String itemName;

    public PackingListItem(PackingList packingList, boolean packed, String itemName) {
        this.packingList = packingList;
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

    public PackingList getIndividualPackingList() {
        return packingList;
    }

    public void setIndividualPackingList(PackingList packingList) {
        this.packingList = packingList;
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
