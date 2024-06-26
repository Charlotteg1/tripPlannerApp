package com.tripPlanner.demo.repostitories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tripPlanner.demo.models.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);
}
