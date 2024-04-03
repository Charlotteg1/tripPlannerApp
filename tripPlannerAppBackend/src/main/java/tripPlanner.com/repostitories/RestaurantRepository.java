package tripPlanner.com.repostitories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tripPlanner.com.models.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant,Long> {
}
