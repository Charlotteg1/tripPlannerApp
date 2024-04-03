package tripPlanner.com.repostitories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tripPlanner.com.models.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
