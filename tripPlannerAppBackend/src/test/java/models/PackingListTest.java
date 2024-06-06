package models;

import com.tripPlanner.demo.models.PackingList;
import com.tripPlanner.demo.models.PackingListItem;
import com.tripPlanner.demo.models.Trip;
import com.tripPlanner.demo.models.User;
import com.tripPlanner.demo.models.enums.Climate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    public void testDefaultConstructor() {
        PackingList packingList = new PackingList();
        assertThat(packingList).isNotNull();

        assertThat(packingList.getTrip()).isNull();
        assertThat(packingList.getListName()).isNull();
    }

    @Test
    void testGetId() {
        packingList.setId(2L);
        Long listId = packingList.getId();
        assertThat(listId).isEqualTo(2L);
    }

    @Test
    void testSetId() {
        packingList.setId(3L);
        assertThat(packingList.getId()).isEqualTo(3L);
    }

    @Test
    public void testGetTrip(){
        Trip tripFound = packingList.getTrip();
        assertThat(tripFound).isEqualTo(trip);
    }

    @Test
    public void testSetTrip() {
        packingList.setTrip(trip);
        assertThat(packingList.getTrip()).isEqualTo(trip);
    }

    @Test
    public void testGetListName() {
        String listName = packingList.getListName();
        assertThat(listName).isEqualTo("Green Suitcase");
    }

    @Test
    public void testSetListName(){
        packingList.setListName("blue suitcase");
        assertThat(packingList.getListName()).isEqualTo("blue suitcase");
    }

//    test getItems and setItems
    @Test
    void testGetItems() {
        List<PackingListItem> items = packingList.getItems();
        assertThat(items).isNotNull();
        assertThat(items.isEmpty()).isTrue();
    }

    @Test
    void testSetItems() {
        List<PackingListItem> newItems = new ArrayList<>();
        newItems.add(new PackingListItem(packingList, false, "Lead"));
        newItems.add(new PackingListItem(packingList, true,"plug"));
        packingList.setItems(newItems);
        assertThat(packingList.getItems()).isEqualTo(newItems);
    }


}
