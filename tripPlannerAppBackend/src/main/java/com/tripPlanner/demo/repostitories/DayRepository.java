package com.tripPlanner.demo.repostitories;

import com.tripPlanner.demo.models.Day;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface DayRepository extends JpaRepository<Day,Long> {

    Day findByDate(LocalDate date);
}
