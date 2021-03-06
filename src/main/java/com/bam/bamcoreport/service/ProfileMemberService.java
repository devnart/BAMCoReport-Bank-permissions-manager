package com.bam.bamcoreport.service;

import com.bam.bamcoreport.dto.model.ProfileMemberDto;
import com.bam.bamcoreport.dto.services.IMapDto;
import com.bam.bamcoreport.entity.ProfileMember;
import com.bam.bamcoreport.repository.ProfileMemberRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileMemberService {

    private static final Logger log = LoggerFactory.getLogger(ProfileMemberService.class);

    ProfileMemberRepository profileMemberRepository;

    @Autowired
    IMapDto<ProfileMember, ProfileMemberDto> memberMapping;

    public ProfileMemberService(ProfileMemberRepository profileMemberRepository) {
        this.profileMemberRepository = profileMemberRepository;
    }

    public List<ProfileMemberDto> getAll(){

        List<ProfileMember> profiles= profileMemberRepository.findAll();
        return memberMapping.convertListToListDto(profiles,ProfileMemberDto.class);
    }

    public void add(ProfileMember profileMember){
        profileMemberRepository.save(profileMember);
    }

}
