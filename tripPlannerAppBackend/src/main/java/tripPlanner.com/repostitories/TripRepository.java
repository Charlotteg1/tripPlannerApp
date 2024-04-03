package tripPlanner.com.repostitories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tripPlanner.com.models.Trip;

@Repository
public interface TripRepository extends JpaRepository<Trip,Long> {
}
