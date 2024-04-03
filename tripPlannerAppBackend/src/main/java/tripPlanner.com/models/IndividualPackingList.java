package tripPlanner.com.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "individual_packing_list")
public class IndividualPackingList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String listName;

    @Column
    private List<PackingListItem> items;

    public IndividualPackingList(String listName, List<PackingListItem> items) {
        this.listName = listName;
        this.items = items;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
