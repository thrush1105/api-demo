package com.example.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.domain.model.User;
import com.example.domain.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

}
