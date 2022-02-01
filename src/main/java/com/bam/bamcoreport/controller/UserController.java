package com.bam.bamcoreport.controller;

import com.bam.bamcoreport.dto.model.UserDto;
import com.bam.bamcoreport.entity.Users;
import com.bam.bamcoreport.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/users")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDto> getUsers() {
        log.info("Showing users list");
        return userService.getUsers();
    }

    @PostMapping
    public void addUser(@RequestBody Users user){
        log.info("User added");
        userService.newUser(user);
    }

    @DeleteMapping(path = "{userId}")
    public void deleteUser(@PathVariable("userId") Long userId){
        log.warn("user deleted");
        userService.deleteUser(userId);
    }

}
