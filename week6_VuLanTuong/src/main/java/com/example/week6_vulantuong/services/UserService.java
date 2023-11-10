package com.example.week6_vulantuong.services;

import com.example.week6_vulantuong.models.User;
import com.example.week6_vulantuong.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public Optional<User> findByEmail(String email, String password){
        return userRepository.findByEmailAndPasswordHash(email, password);
    }

    public Optional<User> findUser(String email){
        return userRepository.findByEmail(email);
    }
}
