package com.salon.booking.controller;

import com.salon.booking.exception.UserException;
import com.salon.booking.model.User;
import com.salon.booking.repository.UserRepository;
import com.salon.booking.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @Autowired
    private  UserRepository userRepository;

    @PostMapping("/api/create/user")
    public ResponseEntity<User> createUser(@RequestBody @Valid User user){
        User createUser = userService.createUser(user);
        return new ResponseEntity<>(createUser, HttpStatus.CREATED);
    }

    @GetMapping("/api/get/all/users")
    public ResponseEntity<List<User>> getAllUser(){
            List<User> users = userService.getAllUser();
            return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/api/get/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) throws Exception{
            User user = userService.getUserById(id);
            return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("/api/update/user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id,
                           @RequestBody User updateUser) throws Exception {
        User updatedUser = userService.updateUser(id, updateUser);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);

    }

    @DeleteMapping("/api/delete/user/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long id) throws Exception{
            userService.deleteUserById(id);
            return new ResponseEntity<>("User deleted Successfully", HttpStatus.ACCEPTED);
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
