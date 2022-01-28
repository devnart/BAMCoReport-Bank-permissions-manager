package com.bam.bamcoreport.service;

import com.bam.bamcoreport.entity.UserContactInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserContactInfoService {
    private final UserContactInfoService userContactInfoService;

    @Autowired
    public UserContactInfoService(UserContactInfoService userContactInfoService) {
        this.userContactInfoService = userContactInfoService;
    }

    public List<UserContactInfo> getAllUserContactInfo() {
        return userContactInfoService.getAllUserContactInfo();
    }

}
