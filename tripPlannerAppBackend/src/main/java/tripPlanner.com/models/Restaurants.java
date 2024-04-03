package tripPlanner.com.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "restaurants")
public class Restaurants {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String Name;

    @Enumerated
    private List<Meal> meal;

    @Column
    private List<ItemConsumed> itemsConsumed;

    @Column
    private Float establishmentRating;

    @Column
    private Boolean wouldVisitAgain; // may change to recommend

    public Restaurants(String name, List<Meal> meal, List<ItemConsumed> itemsConsumed, Float establishmentRating, Boolean wouldVisitAgain) {
        Name = name;
        this.meal = meal;
        this.itemsConsumed = itemsConsumed;
        this.establishmentRating = establishmentRating;
        this.wouldVisitAgain = wouldVisitAgain;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public List<Meal> getMeal() {
        return meal;
    }

    public void setMeal(List<Meal> meal) {
        this.meal = meal;
    }

    public List<ItemConsumed> getItemsConsumed() {
        return itemsConsumed;
    }

    public void setItemsConsumed(List<ItemConsumed> itemsConsumed) {
        this.itemsConsumed = itemsConsumed;
    }

    public Float getEstablishmentRating() {
        return establishmentRating;
    }

    public void setEstablishmentRating(Float establishmentRating) {
        this.establishmentRating = establishmentRating;
    }

    public Boolean getWouldVisitAgain() {
        return wouldVisitAgain;
    }

    public void setWouldVisitAgain(Boolean wouldVisitAgain) {
        this.wouldVisitAgain = wouldVisitAgain;
    }
}
