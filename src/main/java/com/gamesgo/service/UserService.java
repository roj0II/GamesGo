package com.gamesgo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamesgo.model.User;
import com.gamesgo.repository.UserRepository;
import com.gamesgo.util.PasswordManager;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean authenticate(String username, String password) {
        User user = userRepository.findByUsername(username);
        return user != null && PasswordManager.checkPassword(password, user.getPassword());
    }
    
    public User findByUsername (String username) {
    	return userRepository.findByUsername(username);
    }

    public boolean register(User user) {
        if (userRepository.findByUsername(user.getUsername()) != null) {
            return false; // User already exists
        }
        userRepository.save(user);
        return true;
    }
}
