package com.Fastvan.Assignment.Fastvan.Assignment.Service;

import com.Fastvan.Assignment.Fastvan.Assignment.Entity.User;
import com.Fastvan.Assignment.Fastvan.Assignment.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }



}
