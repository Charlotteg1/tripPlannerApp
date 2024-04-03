package tripPlanner.com.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "restaurants")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "day_id")
    @ManyToOne
    @JsonIgnoreProperties({"days"})
    private Long dayId;
    @Column
    private String name;

    @Enumerated
    private List<Meal> meal;

    @Column(name = "items_consumed")
    private List<ItemConsumed> itemsConsumed;

    @Column(name = " establishment_rating")
    private Float establishmentRating;

    @Column(name = "would_visit_again")
    private Boolean wouldVisitAgain; // may change to recommend

    public Restaurant(Long dayId, String name, List<Meal> meal, List<ItemConsumed> itemsConsumed, Float establishmentRating, Boolean wouldVisitAgain) {
        this.dayId = dayId;
        this.name = name;
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
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
