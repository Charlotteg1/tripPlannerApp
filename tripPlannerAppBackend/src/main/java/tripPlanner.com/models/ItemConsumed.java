package tripPlanner.com.models;

public class ItemConsumed {

    private String name;
    private Float rating;

    private String notes;

    // in future enable a picture to be stored of dish eaten (eg)

    public ItemConsumed(String name, Float rating, String notes) {
        this.name = name;
        this.rating = rating;
        this.notes = notes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
