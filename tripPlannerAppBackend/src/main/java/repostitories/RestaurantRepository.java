package repostitories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import models.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant,Long> {
}
