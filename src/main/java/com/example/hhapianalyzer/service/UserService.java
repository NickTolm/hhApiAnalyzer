package com.example.hhapianalyzer.service;

import com.example.hhapianalyzer.entity.User;
import com.example.hhapianalyzer.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public  void save(User user) {
        userRepository.save(user);
    }
}
