package com.bam.bamcoreport.controller;

import com.bam.bamcoreport.entity.UserMembership;
import com.bam.bamcoreport.service.UserMembershipService;
import com.bam.bamcoreport.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/userMembership")
public class UserMembershipController {
    private static final Logger log = LoggerFactory.getLogger(UserMembershipController.class);

    private final UserMembershipService userMembershipService;

    @Autowired
    public UserMembershipController(UserMembershipService userMembershipService) {
        this.userMembershipService = userMembershipService;
    }

    @GetMapping
    public List<UserMembership> getAll(){
        return userMembershipService.getAll();
    }

    @PostMapping
    public void add(UserMembership userMembership){
        userMembershipService.add(userMembership);
    }

}
