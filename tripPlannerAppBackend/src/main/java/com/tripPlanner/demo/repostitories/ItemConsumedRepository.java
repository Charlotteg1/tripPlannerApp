package com.tripPlanner.demo.repostitories;

import com.tripPlanner.demo.models.ItemConsumed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemConsumedRepository extends JpaRepository<ItemConsumed, Long> {
}
