package com.bam.bamcoreport.service;

import com.bam.bamcoreport.dto.model.UserDto;
import com.bam.bamcoreport.dto.services.IMapDto;
import com.bam.bamcoreport.dto.services.MapDto;
import com.bam.bamcoreport.entity.Users;
import com.bam.bamcoreport.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    UserRepository userRepository;

    @Autowired
    IMapDto<Users, UserDto> userMapping;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDto> getUsers() {
        List<Users> users= userRepository.findAll();
        return userMapping.convertListToListDto(users,UserDto.class);
    }

    public void newUser(Users user) {
        Optional<Users> username = userRepository.findByUsername(user.getUsername());
        if (username.isPresent()) {
            log.error("username taken");
            throw new IllegalStateException("username taken");
        }

        userRepository.save(user);
    }

    public void deleteUser(Long userId) {

        boolean exists =  userRepository.existsById(userId);

        if (!exists) {
            log.error("user not found");
            throw new IllegalStateException("user not found");
        }

        userRepository.deleteById(userId);

    }
}
