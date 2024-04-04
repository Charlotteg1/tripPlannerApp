package com.tripPlanner.demo.repostitories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tripPlanner.demo.models.User;

//@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
