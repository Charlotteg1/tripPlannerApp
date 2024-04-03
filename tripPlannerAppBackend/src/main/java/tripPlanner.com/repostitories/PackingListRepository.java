package tripPlanner.com.repostitories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tripPlanner.com.models.PackingList;

@Repository
public interface PackingListRepository extends JpaRepository<PackingList,Long> {
}
