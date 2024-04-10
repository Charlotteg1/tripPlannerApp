package com.tripPlanner.demo.services;

import com.tripPlanner.demo.models.User;
import com.tripPlanner.demo.models.dtos.UserDTO;
import com.tripPlanner.demo.repostitories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
//    need to be able to add new user
//    check login details are correct
//    have the option to update user info

    @Autowired
    UserRepository userRepository;

    public User getUserById(Long id){
        User userToFind = userRepository.findById(id).get();
        if(userToFind != null){
            return userToFind;
        }else{
            return null;
        }
    }

    public User addUser(UserDTO userDTO) {
        //checks email is not already in use
        if (userRepository.findByEmail(userDTO.getEmail()) == null) {
            User user = new User(userDTO.getForename(), userDTO.getSurname(), userDTO.getEmail(), userDTO.getPassword());
            return userRepository.save(user);
        }else {
            return null;
        }
    }

    public User checkLoginCredentials(String email, String password){
        User user = userRepository.findByEmail(email);
        if(user != null && user.getPassword().matches(password)){
            return user;
        }else{
            return null;
        }
    }

    public User updateUser(Long id, String forename,String surname) {

        User user = userRepository.findById(id).get();

        if(forename != null){
            user.setForename(forename);
        }else if (surname != null) {
            user.setSurname(surname);
        }
        return userRepository.save(user);
    }
}