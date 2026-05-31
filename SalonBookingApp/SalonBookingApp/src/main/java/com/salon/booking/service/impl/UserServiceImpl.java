package com.salon.booking.service.impl;

import com.salon.booking.exception.UserException;
import com.salon.booking.model.User;
import com.salon.booking.repository.UserRepository;
import com.salon.booking.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) throws UserException {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            return user.get();
        }
        throw new UserException("User Not Found");
    }

    @Override
    public User updateUser(Long id, User updateUser) throws UserException {
       Optional<User> user = userRepository.findById(id);
       if (user.isEmpty()){
           throw new UserException("User Not Found");
       }
       User user1= user.get();
       user1.setFullName(updateUser.getFullName());
       user1.setEmail(updateUser.getEmail());
       user1.setPhone(updateUser.getPhone());
       user1.setRole(updateUser.getRole());
       return userRepository.save(user1);
    }

    @Override
    public String deleteUserById(Long id) throws UserException {
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty()){
            throw new UserException("User Not Found");
        }
        userRepository.deleteById(user.get().getId());
        return "User Deleted Successfully";
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }
}
