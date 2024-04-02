package tripPlanner.com.models;

public class PackingListItem {

    private boolean packed;

    private String itemName;

    public PackingListItem(boolean packed, String itemName) {
        this.packed = packed;
        this.itemName = itemName;
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
