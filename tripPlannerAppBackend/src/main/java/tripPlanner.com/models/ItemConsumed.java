package tripPlanner.com.models;

import jakarta.persistence.*;

@Entity
@Table(name = "items_consumed")
public class ItemConsumed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private Float rating;

    @Column
    private String notes;

    // in future enable a picture to be stored of dish eaten (eg)

    public ItemConsumed(String name, Float rating, String notes) {
        this.name = name;
        this.rating = rating;
        this.notes = notes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
