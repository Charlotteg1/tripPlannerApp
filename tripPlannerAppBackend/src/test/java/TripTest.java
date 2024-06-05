import com.tripPlanner.demo.models.Trip;
import com.tripPlanner.demo.models.User;
import com.tripPlanner.demo.models.enums.Climate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TripTest {

    private Trip trip;

    private User user;

    @BeforeEach
    public void setUp(){
        user =  new User("Claire", "Roy", "clairer@gmail.com", "Apples23");
        user.setId(1L);
        trip = new Trip(user, "London", LocalDate.of(2024, 7, 23), LocalDate.of(2024, 7, 28), Climate.Warm);
    }

    @Test
    void testTripGetUser() {
        User userFound = trip.getUser();
        assertThat(userFound).isEqualTo(user);
    }

    @Test
    void testTripSetUser() {
        User user1 = new User("Maryam", "Hay", "maryamhay@gmail.com", "Doris2Amazing");
        trip.setUser(user1);
        assertThat(trip.getUser()).isEqualTo(user1);
    }

    @Test
    void testUserGetDestination() {
        String tripDestination = trip.getDestination();
        assertThat(tripDestination).isEqualTo("London");
    }

    @Test
    void testUserSetDestination() {
        trip.setDestination("Bath");
        assertThat(trip.getDestination()).isEqualTo("Bath");
    }

    @Test
    void testUserGetTripStartDate() {
        LocalDate tripStartDate = trip.getTripStartDate();
        assertThat(tripStartDate).isEqualTo(LocalDate.of(2024, 7, 23));
    }

    @Test
    void testUserSetTripStartDate() {
        trip.setTripStartDate(LocalDate.of(2024, 7, 25));
        assertThat(trip.getTripStartDate()).isEqualTo(LocalDate.of(2024, 7, 25));
    }

    @Test
    void testUserGetTripEndDate() {
        LocalDate tripEndDate = trip.getTripEndDate();
        assertThat(tripEndDate).isEqualTo(LocalDate.of(2024, 7, 28));
    }

    @Test
    void testUserSetTripEndDate() {
        trip.setTripStartDate(LocalDate.of(2024, 8, 1));
        assertThat(trip.getTripStartDate()).isEqualTo(LocalDate.of(2024, 8, 1));
    }

    @Test
    void testUserGetClimate() {
        Climate climate = trip.getClimate();
        assertThat(climate).isEqualTo(Climate.Warm);
    }

    @Test
    void testUserSetClimate() {
        trip.setClimate(Climate.Hot);
        assertThat(trip.getClimate()).isEqualTo(Climate.Hot);
    }

//    need to test getters and setter for packingList , transportationList, days


}
