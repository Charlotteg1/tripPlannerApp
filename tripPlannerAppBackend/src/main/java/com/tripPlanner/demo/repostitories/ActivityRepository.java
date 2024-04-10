package com.tripPlanner.demo.repostitories;

import com.tripPlanner.demo.models.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

//@Repository
public interface ActivityRepository extends JpaRepository<Activity,Long> {
}
