package tripPlanner.com.models;

import java.time.LocalDate;
import java.util.List;

public class Trip {

    //Properties
    private Long tripId;

    private Long userId;

    private LocalDate tripStartDate;

    private LocalDate tripEndDate;

    private Climate climate;

    private PackingList packingList;

    private List<Transportation> transportationList;

    //Constructor
    public Trip(Long userId, LocalDate tripStartDate, LocalDate tripEndDate, Climate climate, List<Transportation> transportationList ) {
        this.userId = userId;
        this.tripStartDate = tripStartDate;
        this.tripEndDate = tripEndDate;
        this.climate = climate;
        this.packingList=null;
        this.transportationList= transportationList;
    }


    //Default Constructor
    public Trip() {
    }

    //Getters and Setters

    public Long getTripId() {
        return tripId;
    }

    public void setTripId(Long tripId) {
        this.tripId = tripId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDate getTripStartDate() {
        return tripStartDate;
    }

    public void setTripStartDate(LocalDate tripStartDate) {
        this.tripStartDate = tripStartDate;
    }

    public LocalDate getTripEndDate() {
        return tripEndDate;
    }

    public void setTripEndDate(LocalDate tripEndDate) {
        this.tripEndDate = tripEndDate;
    }

    public Climate getClimate() {
        return climate;
    }

    public void setClimate(Climate climate) {
        this.climate = climate;
    }

    public PackingList getPackingList() {
        return packingList;
    }

    public void setPackingList(PackingList packingList) {
        this.packingList = packingList;
    }

    public List<Transportation> getTransportationList() {
        return transportationList;
    }

    public void setTransportationList(List<Transportation> transportationList) {
        this.transportationList = transportationList;
    }
}
