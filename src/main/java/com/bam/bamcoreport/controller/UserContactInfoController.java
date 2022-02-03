package com.bam.bamcoreport.controller;

import com.bam.bamcoreport.dto.model.UserContactInfoDto;
import com.bam.bamcoreport.entity.UserContactInfo;
import com.bam.bamcoreport.service.UserContactInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/userContactInfo")

public class UserContactInfoController {
    UserContactInfoService userContactInfoService;

    @Autowired
    public UserContactInfoController(UserContactInfoService userContactInfoService) {
        this.userContactInfoService = userContactInfoService;
    }

    @GetMapping
    public List<UserContactInfoDto> getUserContactInfo() {
        return userContactInfoService.getAllUserContactInfo();
    }

    @PostMapping
    public void addUserContactInfo(@RequestBody UserContactInfo userContactInfo) {
        userContactInfoService.newUserContactInfo(userContactInfo);
    }

}
