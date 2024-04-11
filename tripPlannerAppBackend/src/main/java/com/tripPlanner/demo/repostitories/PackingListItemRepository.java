package com.tripPlanner.demo.repostitories;

import com.tripPlanner.demo.models.PackingListItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PackingListItemRepository extends JpaRepository<PackingListItem,Long> {
}
