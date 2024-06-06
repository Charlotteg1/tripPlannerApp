package models;

import com.tripPlanner.demo.models.PackingList;
import com.tripPlanner.demo.models.PackingListItem;
import com.tripPlanner.demo.models.Trip;
import com.tripPlanner.demo.models.User;
import com.tripPlanner.demo.models.enums.Climate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PackingListItemTest {

    private PackingList packingList;

    private PackingListItem packingListItem;


    @BeforeEach
    public void setUp(){
        User user = new User("Frank","Green", "fgreen1978@yahoo.com", "Notebook1978");
        Trip trip = new Trip(user, "Nice", LocalDate.of(2024, 7,2), LocalDate.of(2024, 7, 14), Climate.Hot);
        packingList = new PackingList(trip, "Green Suitcase");
        packingListItem = new PackingListItem(packingList, true, "Charger");
    }

    @Test
    void testDefaultConstructor() {
        PackingListItem packingListItem = new PackingListItem();
        assertThat(packingListItem).isNotNull();

//      ensure fields are null
        assertThat(packingListItem.getPackingList()).isNull();
        assertThat(packingListItem.getItemName()).isNull();
        assertThat(packingListItem.isPacked()).isFalse();
    }

    @Test
    void testGetId() {
        packingListItem.setId(2L);
        Long itemId = packingListItem.getId();
        assertThat(itemId).isEqualTo(2L);
    }

    @Test
    void testSetId() {
        packingListItem.setId(3L);
        assertThat(packingListItem.getId()).isEqualTo(3L);
    }

    @Test
    public void testGetPackingList(){
        PackingList packingListFound = packingListItem.getPackingList();
        assertThat(packingListFound).isEqualTo(packingList);
    }

    @Test
    void testSetPackingList() {
        packingListItem.setPackingList(packingList);
        assertThat(packingListItem.getPackingList()).isEqualTo(packingList);
        assertThat(packingListItem.getPackingList().getListName()).isEqualTo("Green Suitcase");
    }

    @Test
    public void testIsPacked(){
        Boolean itemPackedStatus = packingListItem.isPacked();
        assertThat(itemPackedStatus).isEqualTo(true);
    }

    @Test
    void testSetPacked() {
        packingListItem.setPacked(false);
        assertThat(packingListItem.isPacked()).isEqualTo(false);
    }

    @Test
    public void testGetItemName(){
        String itemName = packingListItem.getItemName();
        assertThat(itemName).isEqualTo("Charger");
    }

    @Test
    void testSetItemName() {
        packingListItem.setItemName("phone charger");
        assertThat(packingListItem.getItemName()).isEqualTo("phone charger");
    }


}
