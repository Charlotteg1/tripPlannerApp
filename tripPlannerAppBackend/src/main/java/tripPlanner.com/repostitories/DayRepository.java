package tripPlanner.com.repostitories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tripPlanner.com.models.Day;

@Repository
public interface DayRepository extends JpaRepository<Day,Long> {
}
