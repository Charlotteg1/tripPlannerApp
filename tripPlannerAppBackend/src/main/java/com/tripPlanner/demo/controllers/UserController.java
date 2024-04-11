package com.tripPlanner.demo.controllers;


import com.tripPlanner.demo.models.User;
import com.tripPlanner.demo.models.dtos.UserDTO;
import com.tripPlanner.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
//    get user by id
//    add user
//    authenticate user
//    update user

    @Autowired
    UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<User> findUserById(@PathVariable Long id){
        User findUser = userService.getUserById(id);
        if(findUser!=null){
            return new ResponseEntity<>(findUser, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping("/addUser")
    public ResponseEntity<User> addUser(@RequestBody UserDTO userDTO){
        User newUser = userService.addUser(userDTO);
        if(newUser!=null){
            return new ResponseEntity<>(newUser, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/authenticate")
    public ResponseEntity<User> checkLogin(@RequestBody Map<String, String> requestBody){
        String email = requestBody.get("email");
        String password = requestBody.get("password");
        User checkedUser = userService.checkLoginCredentials(email,password);
        if(checkedUser!=null){
            return new ResponseEntity<>(checkedUser, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestParam String forename, @RequestParam String surname){
        User updateUser = userService.updateUser(id, forename, surname);
        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }

}
