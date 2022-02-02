package com.bam.bamcoreport.service;

import com.bam.bamcoreport.entity.ProfileMember;
import com.bam.bamcoreport.repository.ProfileMemberRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileMemberService {

    private static final Logger log = LoggerFactory.getLogger(ProfileMemberService.class);

    ProfileMemberRepository profileMemberRepository;

    public ProfileMemberService(ProfileMemberRepository profileMemberRepository) {
        this.profileMemberRepository = profileMemberRepository;
    }

    public List<ProfileMember> getAll(){
        return profileMemberRepository.findAll();
    }

    public void add(ProfileMember profileMember){
        profileMemberRepository.save(profileMember);
    }

}
