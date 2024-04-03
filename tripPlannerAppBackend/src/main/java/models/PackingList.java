package models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "packing_list")
public class PackingList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "trip_id")
    @OneToOne
    private Long tripId;

    @Column(name = "packing_lists")
    private List<IndividualPackingList> packingLists;

    public PackingList(Long tripId, List<IndividualPackingList> packingLists) {
        this.tripId = tripId;
        this.packingLists = packingLists;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTripId() {
        return tripId;
    }

    public void setTripId(Long tripId) {
        this.tripId = tripId;
    }

    public List<IndividualPackingList> getPackingLists() {
        return packingLists;
    }

    public void setPackingLists(List<IndividualPackingList> packingLists) {
        this.packingLists = packingLists;
    }
}
