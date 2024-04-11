package com.tripPlanner.demo.repostitories;

import com.tripPlanner.demo.models.PackingList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PackingListRepository extends JpaRepository<PackingList,Long> {
}
