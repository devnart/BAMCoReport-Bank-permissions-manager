package com.bam.bamcoreport.service;

import com.bam.bamcoreport.entity.Users;
import com.bam.bamcoreport.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Users> getUsers() {
        return userRepository.findAll();
    }

    public void newUser(Users user) {
        Optional<Users> username = userRepository.findByUsername(user.getUsername());
        if (username.isPresent()) {
            throw new IllegalStateException("username taken");
        }

        userRepository.save(user);
    }

    public void deleteUser(Long userId) {

        boolean exists =  userRepository.existsById(userId);

        if (!exists) {
            throw new IllegalStateException("user not found");
        }

        userRepository.deleteById(userId);

    }
}
