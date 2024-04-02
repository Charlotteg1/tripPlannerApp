package tripPlanner.com.models;

import java.util.List;

public class User {

    //Properties
    private Long id;

    private String forename;

    private String surname;

    private String email;

    private String password; //Authorisation and encrypt later..

    private List<Trip> trips;

    //Constructor
    public User(String forename, String surname, String email, String password, List<Trip> trips) {
        this.forename = forename;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.trips = trips;
    }

    //Default Constructor
    public User() {}

    //Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Trip> getTrips() {

        return trips;
    }

    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }
}
