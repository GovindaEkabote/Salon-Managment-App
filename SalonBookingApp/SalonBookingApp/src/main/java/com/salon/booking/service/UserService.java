package com.salon.booking.service;

import com.salon.booking.exception.UserException;
import com.salon.booking.model.User;

import java.util.List;

public interface UserService {

    User createUser(User user);
    User getUserById(Long id) throws UserException;
    User updateUser(Long id, User updateUser) throws UserException;
    String deleteUserById(Long id) throws UserException;
    List<User> getAllUser();
}
