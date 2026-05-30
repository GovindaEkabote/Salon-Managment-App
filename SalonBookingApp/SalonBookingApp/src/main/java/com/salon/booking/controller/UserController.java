package com.salon.booking.controller;

import com.salon.booking.model.User;
import com.salon.booking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private  UserRepository userRepository;

    @PostMapping("/api/create/user")
    public User createUser(@RequestBody  User user){
        return userRepository.save(user);
    }

    @GetMapping("/api/get/all/users")
    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    @GetMapping("/api/get/user/{id}")
    public User getUserById(@PathVariable Long id) throws Exception{
        Optional<User>  user = userRepository.findById(id);
        if(user.isPresent()){
            return user.get();
        }
        throw new Exception("User Not Found");
    }

    @PutMapping("/api/update/user/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User updateUser) {

        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        if (updateUser.getFullName() != null) {
            existingUser.setFullName(updateUser.getFullName());
        }

        if (updateUser.getEmail() != null) {
            existingUser.setEmail(updateUser.getEmail());
        }

        if (updateUser.getPhone() != null) {
            existingUser.setPhone(updateUser.getPhone());
        }

        if (updateUser.getRole() != null) {
            existingUser.setRole(updateUser.getRole());
        }

        return userRepository.save(existingUser);
    }

    @GetMapping("/user")
    public User getUser(){
        User user = new User();
        user.setFullName("Govinda");
        user.setEmail("govinda@gmail.com");
        user.setRole("admin");
        user.setPhone("1234567890");
        return user;
    }

}
