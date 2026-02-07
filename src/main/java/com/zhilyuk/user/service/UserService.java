package com.zhilyuk.user.service;

import com.zhilyuk.user.model.User;
import com.zhilyuk.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User updateUser(Long userId, User newUser) {
        User user = userRepository.findById(userId).orElseThrow();
        user.setName(newUser.getName());
        user.setDateOfBirth(newUser.getDateOfBirth());
        return userRepository.save(user);
    }

    public void deleteUser(Long userId){
        if (userRepository.existsById(userId)) {
            userRepository.deleteById(userId);
        }
    }
}
