package com.tripPlanner.demo.repostitories;

import com.tripPlanner.demo.models.PackingList;
import org.springframework.data.jpa.repository.JpaRepository;

//@Repository
public interface PackingListRepository extends JpaRepository<PackingList,Long> {
}
