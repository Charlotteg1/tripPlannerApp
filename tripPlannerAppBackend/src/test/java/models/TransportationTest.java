package models;

import com.tripPlanner.demo.models.Transportation;
import com.tripPlanner.demo.models.Trip;
import com.tripPlanner.demo.models.User;
import com.tripPlanner.demo.models.enums.Climate;
import com.tripPlanner.demo.models.enums.ModeOfTransport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TransportationTest {


    private Trip trip;

    private Transportation transportation;

    @BeforeEach
    public void setUp(){
        User user =  new User("Claire", "Roy", "clairer@gmail.com", "Apples23");
        user.setId(1L);
        trip = new Trip(user, "London", LocalDate.of(2024, 7, 23), LocalDate.of(2024, 7, 28), Climate.Warm);
        transportation = new Transportation(trip, "Edinburgh", "London Luton", LocalDateTime.of(2024,7,23, 11, 30, 00), LocalDateTime.of(2024,07,23,12, 40, 00), ModeOfTransport.Plane);
    }

    @Test
    public void testGetTrip(){
        Trip tripFound = transportation.getTrip();
        assertThat(tripFound).isEqualTo(trip);
    }

    @Test
    void testSetTrip() {
        transportation.setTrip(trip);
        assertThat(transportation.getTrip()).isEqualTo(trip);
    }

    @Test
    void testGetDepartureDestination() {
        String departureDestination = transportation.getDepartureDestination();
        assertThat(departureDestination).isEqualTo("Edinburgh");
    }

    @Test
    void testSetDepartureDestination() {
        transportation.setDepartureDestination("Glasgow");
        assertThat(transportation.getDepartureDestination()).isEqualTo("Glasgow");
    }

    @Test
    void testGetArrivalDestination() {
        String arrivalDestination = transportation.getArrivalDestination();
        assertThat(arrivalDestination).isEqualTo("London Luton");
    }

    @Test
    void testSetArrivalDestination() {
        transportation.setArrivalDestination("London City");
        assertThat(transportation.getArrivalDestination()).isEqualTo("London City");
    }

    @Test
    void testGetDepartureTimeAndDate() {
        LocalDateTime departureTimeAndDate = transportation.getDepartureTimeAndDate();
        assertThat(departureTimeAndDate).isEqualTo(LocalDateTime.of(2024,07,23, 11,30, 00));
    }

    @Test
    void testSetDepartureTimeAndDate() {
        transportation.setDepartureTimeAndDate(LocalDateTime.of(2024, 07, 23, 12, 05,00));
        assertThat(transportation.getDepartureTimeAndDate()).isEqualTo(LocalDateTime.of(2024, 07, 23, 12, 05,00));
    }

    @Test
    void testGetArrivalTimeAndDate() {
        LocalDateTime arrivalTimeAndDate = transportation.getArrivalTimeAndDate();
        assertThat(arrivalTimeAndDate).isEqualTo(LocalDateTime.of(2024, 07, 23, 12, 40,00));
    }

    @Test
    void testSetArrivalTimeAndDate() {
        transportation.setArrivalTimeAndDate(LocalDateTime.of(2024, 07, 23, 13,35,00));
        assertThat(transportation.getArrivalTimeAndDate()).isEqualTo(LocalDateTime.of(2024, 07, 23, 13, 35,00));
    }

    @Test
    void testGetMode() {
        ModeOfTransport modeOfTransport = transportation.getMode();
        assertThat(modeOfTransport).isEqualTo(ModeOfTransport.Plane);
    }

    @Test
    void testSetMode() {
        transportation.setMode(ModeOfTransport.Coach);
        assertThat(transportation.getMode()).isEqualTo(ModeOfTransport.Coach);
    }

}
