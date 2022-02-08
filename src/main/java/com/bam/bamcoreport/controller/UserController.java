package com.bam.bamcoreport.controller;

import com.bam.bamcoreport.dto.model.UserDto;
import com.bam.bamcoreport.entity.Users;
import com.bam.bamcoreport.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/users")
@Api(tags = "Utilisateur", value = "Utilisateur Controller")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    @ApiResponses({ @ApiResponse(code = 500, message = "Une erreur système s'est produite") })
    @ApiOperation(value = "", nickname = "Retourne la liste des utilisateurs", notes = "", tags = {})
    public List<UserDto> getUsers() {
        log.info("Showing users list");
        return userService.getUsers();
    }

    @PostMapping
    public void addUser(@RequestBody Users user) {
        log.info("User added");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.newUser(user);
    }

    @DeleteMapping(path = "{userId}")
    public void deleteUser(@PathVariable("userId") Long userId){
        log.warn("user deleted");
        userService.deleteUser(userId);
    }

}
