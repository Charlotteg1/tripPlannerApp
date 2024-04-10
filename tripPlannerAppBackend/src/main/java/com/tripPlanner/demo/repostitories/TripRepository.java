package com.tripPlanner.demo.repostitories;

import com.tripPlanner.demo.models.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

//@Repository
public interface TripRepository extends JpaRepository<Trip,Long> {
}
