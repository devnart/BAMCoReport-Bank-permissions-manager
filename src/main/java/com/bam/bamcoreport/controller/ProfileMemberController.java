package com.bam.bamcoreport.controller;


import com.bam.bamcoreport.dto.model.ProfileMemberDto;
import com.bam.bamcoreport.entity.ProfileMember;
import com.bam.bamcoreport.service.ProfileMemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/profileMember")
public class ProfileMemberController {

    private static final Logger log = LoggerFactory.getLogger(ProfileMemberController.class);

    private final ProfileMemberService profileMemberService;


    @Autowired
    public ProfileMemberController(ProfileMemberService profileMemberService) {
        this.profileMemberService = profileMemberService;
    }

    @GetMapping
    public List<ProfileMemberDto> getAll(){
        log.info("Showing Profile member's list");
        return profileMemberService.getAll();
    }

    @PostMapping
    public void add(@RequestBody ProfileMember profileMember){
        log.info("adding profile member");
        profileMemberService.add(profileMember);
    }
}
