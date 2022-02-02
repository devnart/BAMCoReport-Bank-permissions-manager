package com.bam.bamcoreport.service;


import com.bam.bamcoreport.entity.UserMembership;
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

    public UserMembershipService(UserMembershipRepository userMembershipRepository) {
        this.userMembershipRepository = userMembershipRepository;
    }

    public List<UserMembership> getAll(){
        return userMembershipRepository.findAll();
    }

    public void add(UserMembership userMembership){
        userMembershipRepository.save(userMembership);
    }
}

