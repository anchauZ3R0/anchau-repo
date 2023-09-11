package com.full.fullstackbackend.controller;

import com.full.fullstackbackend.exception.UserNotFoundException;
import com.full.fullstackbackend.model.User;
import com.full.fullstackbackend.repository.UserRepository;
import com.full.fullstackbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin("http://localhost:5173/")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user") //post data into the database
    public void newUser(@RequestBody User newUser){
        userService.addNewUser(newUser);
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getUsers();
    }

    @GetMapping("user/{id}")
    public User getUserById(@PathVariable Long id){
        return userService.getUser(id);
    }



    @PutMapping("user/{id}")
    public void updateUser(@PathVariable Long id, @RequestBody User tmp){
         userService.updateUser(id, tmp);
    }

    @DeleteMapping("user/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }
}
