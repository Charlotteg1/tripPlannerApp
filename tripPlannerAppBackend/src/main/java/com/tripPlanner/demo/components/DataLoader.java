package com.tripPlanner.demo.components;

import com.tripPlanner.demo.models.Climate;
import com.tripPlanner.demo.models.Trip;
import com.tripPlanner.demo.models.User;
import com.tripPlanner.demo.repostitories.TripRepository;
import com.tripPlanner.demo.repostitories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TripRepository tripRepository;

    public DataLoader() {
    }

    @Override
    public void run(ApplicationArguments args) throws Exception{

        User user1 = new User("Mia", "Westbrook","mia.westbrook@gmail.com", "mw123");
        userRepository.save(user1);
        User user2 = new User("Kai","Gem", "kairileyg@hotmail.com", "Ketchup353");
        userRepository.save(user2);

        Trip trip1 = new Trip(user2, "New York City", LocalDate.of(2024, 5, 23), LocalDate.of(2024,5,29), Climate.Mild);
        tripRepository.save(trip1);
        Trip trip2 = new Trip(user2, "Thailand", LocalDate.of(2024, 6, 3), LocalDate.of(2024,6,19), Climate.Hot);
        tripRepository.save(trip2);

    }


}
