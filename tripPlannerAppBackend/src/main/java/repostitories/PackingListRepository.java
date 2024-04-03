package repostitories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import models.PackingList;

@Repository
public interface PackingListRepository extends JpaRepository<PackingList,Long> {
}
