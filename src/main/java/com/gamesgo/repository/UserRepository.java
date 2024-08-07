package com.gamesgo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gamesgo.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
    User findByPhone(String phone);
    User findByEmail(String email);
    
}