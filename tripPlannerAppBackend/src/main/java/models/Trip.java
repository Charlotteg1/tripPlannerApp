package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "trips")
public class Trip {

    //Properties
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    @ManyToOne
    @JsonIgnoreProperties({"users"})
    private Long userId;

    @Column(name = "trip_start_date")
    private LocalDate tripStartDate;

    @Column(name = "trip_end_date")
    private LocalDate tripEndDate;

    @Column
    private Climate climate;

    @Column(name = "packing_list")
    @OneToOne(mappedBy = "trip")
    private PackingList packingList;

    @OneToMany(mappedBy = "trip")
    @JsonIgnoreProperties({"trips"})
    private List<Transportation> transportationList;

    @OneToMany(mappedBy = "trip")
    @JsonIgnoreProperties({"trips"})
    private List<Day> days;

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

    public Long getId() {
        return id;
    }

    public void setId(Long Id) {
        this.id = id;
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
