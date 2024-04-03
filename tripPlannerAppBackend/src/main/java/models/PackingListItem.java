package models;

import jakarta.persistence.*;

@Entity
@Table(name = "packing_list_item")
public class PackingListItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private boolean packed;

    @Column(name = "item_name")
    private String itemName;

    public PackingListItem(boolean packed, String itemName) {
        this.packed = packed;
        this.itemName = itemName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isPacked() {
        return packed;
    }

    public void setPacked(boolean packed) {
        this.packed = packed;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
