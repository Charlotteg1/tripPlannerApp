import com.tripPlanner.demo.models.PackingList;
import com.tripPlanner.demo.models.Trip;
import com.tripPlanner.demo.models.User;
import com.tripPlanner.demo.models.enums.Climate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PackingListTest {


    private PackingList packingList;

    private Trip trip;


    @BeforeEach
    public void setUp(){
        User user = new User("Frank","Green", "fgreen1978@yahoo.com", "Notebook1978");
        trip = new Trip(user, "Nice", LocalDate.of(2024, 7,2), LocalDate.of(2024, 7, 14), Climate.Hot);
        packingList = new PackingList(trip, "Green Suitcase");
    }

    @Test
    public void testGetTrip(){
        Trip tripFound = packingList.getTrip();
        assertThat(tripFound).isEqualTo(trip);
    }

    @Test
    void testSetTrip() {
        packingList.setTrip(trip);
        assertThat(packingList.getTrip()).isEqualTo(trip);
    }

    @Test
    void testUserGetListName() {
        String listName = packingList.getListName();
        assertThat(listName).isEqualTo("Green Suitcase");
    }

    @Test
    void testUserSetListName() {
        packingList.setListName("blue suitcase");
        assertThat(packingList.getListName()).isEqualTo("blue suitcase");
    }

//    test getItems and setItems



}
