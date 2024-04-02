package tripPlanner.com.models;

import java.util.List;

public class IndividualPackingList {

    private String listName;

    private List<PackingListItem> items;

    public IndividualPackingList(String listName, List<PackingListItem> items) {
        this.listName = listName;
        this.items = items;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public List<PackingListItem> getItems() {
        return items;
    }

    public void setItems(List<PackingListItem> items) {
        this.items = items;
    }
}
