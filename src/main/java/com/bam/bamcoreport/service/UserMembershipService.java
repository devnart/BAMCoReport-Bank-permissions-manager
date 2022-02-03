package com.bam.bamcoreport.service;


import com.bam.bamcoreport.dto.model.UserDto;
import com.bam.bamcoreport.dto.model.UserMembershipDto;
import com.bam.bamcoreport.dto.services.IMapDto;
import com.bam.bamcoreport.entity.UserMembership;
import com.bam.bamcoreport.entity.Users;
import com.bam.bamcoreport.repository.UserMembershipRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserMembershipService {

    private static final Logger log = LoggerFactory.getLogger(UserMembershipService.class);

    @Autowired
    UserMembershipRepository userMembershipRepository;

    @Autowired
    IMapDto<UserMembership, UserMembershipDto> userMapping;

    public UserMembershipService(UserMembershipRepository userMembershipRepository) {
        this.userMembershipRepository = userMembershipRepository;
    }

    public List<UserMembershipDto> getAll(){
        List<UserMembership> userMemberships = userMembershipRepository.findAll();
        return userMapping.convertListToListDto(userMemberships, UserMembershipDto.class);
    }

    public UserMembershipDto getById(Long id){
        UserMembership userMembership = userMembershipRepository.findById(id).get();
        return userMapping.convertToDto(userMembership, UserMembershipDto.class);
    }

    public void add(UserMembership userMembership){
        userMembershipRepository.save(userMembership);
    }


}

