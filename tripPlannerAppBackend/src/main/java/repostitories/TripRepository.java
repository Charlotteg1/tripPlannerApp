package repostitories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import models.Trip;

@Repository
public interface TripRepository extends JpaRepository<Trip,Long> {
}
