package repostitories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import models.Transportation;

@Repository
public interface TransportationRepository extends JpaRepository<Transportation, Long> {
}
