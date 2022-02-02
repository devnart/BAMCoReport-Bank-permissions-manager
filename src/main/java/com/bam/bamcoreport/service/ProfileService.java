package com.bam.bamcoreport.service;

import com.bam.bamcoreport.entity.Profile;
import com.bam.bamcoreport.repository.ProfileRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public List<Profile> getProfiles(){
        List<Profile> profiles=profileRepository.findAll();
        return profiles;
    }

    public Profile addNewProfile(Profile profile){
        Optional<Profile> name=profileRepository.findByName(profile.getName());
        if (name.isPresent()){
            log.warn("name taken");
            throw new IllegalStateException("name is taken");
        }
        return profileRepository.save(profile);
    }

    public void deleteProfile(Long idProfile){
        boolean exists= profileRepository.existsById(idProfile);

        if (!exists){
            log.error("this profile does not exist");
            throw new IllegalStateException("this profile does not exist");
        }
        profileRepository.deleteById(idProfile);
    }
}
