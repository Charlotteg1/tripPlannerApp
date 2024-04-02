package tripPlanner.com.models;

import java.util.List;

public class PackingList {

    private Long id;
    private Long tripId;

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
