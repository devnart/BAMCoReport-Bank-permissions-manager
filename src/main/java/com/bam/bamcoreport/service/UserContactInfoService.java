package com.bam.bamcoreport.service;

import com.bam.bamcoreport.dto.model.UserContactInfoDto;
import com.bam.bamcoreport.dto.services.IMapDto;
import com.bam.bamcoreport.entity.UserContactInfo;
import com.bam.bamcoreport.repository.UserContactInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserContactInfoService {
    private final UserContactInfoRepository userContactInfoRepository;

    @Autowired
    IMapDto<UserContactInfo, UserContactInfoDto> userCMapping;


    @Autowired
    public UserContactInfoService(UserContactInfoRepository userContactInfoRepository) {
        this.userContactInfoRepository = userContactInfoRepository ;
    }

    public List<UserContactInfoDto> getAllUserContactInfo() {
        List<UserContactInfo> userC= userContactInfoRepository.findAll();
        return userCMapping.convertListToListDto(userC,UserContactInfoDto.class);
    }

    public void newUserContactInfo(UserContactInfo userContactInfo) {
        userContactInfoRepository.save(userContactInfo);
    }




}
