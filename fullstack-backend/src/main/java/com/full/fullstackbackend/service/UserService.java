package com.full.fullstackbackend.service;


import com.full.fullstackbackend.exception.UserNotFoundException;
import com.full.fullstackbackend.model.User;
import com.full.fullstackbackend.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    public List<User> getUsers(){

        return userRepo.findAll();
    }

    public User getUser(Long id) {
        User user = userRepo.findById(id).orElseThrow(() -> new IllegalStateException("User with id " + id + " doesn't exist"));

        return user;
    }

    public void addNewUser(User user) {


        userRepo.save(user);


    }

    public void deleteUser(Long id) {
        boolean exists = userRepo.existsById(id);

        if(!exists){
            throw new IllegalStateException("User with id " + id + " does not exist");
        }

        userRepo.deleteById(id);
    }




    @Transactional
    public void updateUser(Long id, User tmp) {
        User user = userRepo.findById(id).orElseThrow(() -> new IllegalStateException("User with id " + id + " doesn't exist"));



        if(tmp.getName()==null || tmp.getName().length()<=0){
            tmp.setName(user.getName());
        }

        if(tmp.getUsername()==null || tmp.getUsername().length()<=0){
            tmp.setUsername(user.getUsername());
        }

        if(tmp.getEmail()==null || tmp.getEmail().length()<=0){
            tmp.setEmail(user.getEmail());
        }


        user.setName((tmp.getName()));
        user.setUsername((tmp.getUsername()));
        user.setEmail((tmp.getEmail()));












    }

}
