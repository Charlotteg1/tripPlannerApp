package tripPlanner.com.repostitories;

import org.hibernate.sql.ast.tree.expression.JdbcParameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tripPlanner.com.models.Activity;

@Repository
public interface ActivityRepository extends JpaRepository<Activity,Long> {
}
