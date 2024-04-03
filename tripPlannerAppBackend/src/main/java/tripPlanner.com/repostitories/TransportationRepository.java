package tripPlanner.com.repostitories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tripPlanner.com.models.Transportation;

@Repository
public interface TransportationRepository extends JpaRepository<Transportation, Long> {
}
