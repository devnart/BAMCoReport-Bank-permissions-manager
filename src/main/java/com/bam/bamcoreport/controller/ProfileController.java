package com.bam.bamcoreport.controller;


import com.bam.bamcoreport.dto.model.ProfileDto;
import com.bam.bamcoreport.entity.Profile;
import com.bam.bamcoreport.service.ProfileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/profile")
public class ProfileController {
    private static final Logger log = LoggerFactory.getLogger(ProfileController.class);


    private final ProfileService profileService;

    @Autowired
    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping
    public List<ProfileDto> getProfiles(){
        log.info("Listing all profiles");
        return profileService.getProfiles();
    }

    @PostMapping
    public void addProfile(@RequestBody Profile profile){
        log.info("adding profile");
        profileService.addNewProfile(profile);
    }

    @DeleteMapping(path = "{$profileId}")
    public void deleteProfile(@PathVariable("prifileId") Long profileId){
        log.warn("deleting profile");
        profileService.deleteProfile(profileId);
    }

}
