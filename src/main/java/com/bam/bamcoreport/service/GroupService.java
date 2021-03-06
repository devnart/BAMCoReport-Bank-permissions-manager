package com.bam.bamcoreport.service;

import com.bam.bamcoreport.dto.model.GroupsDto;
import com.bam.bamcoreport.dto.services.IMapDto;
import com.bam.bamcoreport.entity.Groups;
import com.bam.bamcoreport.entity.Users;
import com.bam.bamcoreport.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class GroupService {

    private final GroupRepository groupRepository;

    @Autowired
    IMapDto<Groups,GroupsDto> groupsMapping;

    @Autowired
    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public List<GroupsDto> getGroup() {
//        Groups group1 = new Groups(
//                "Group 1",
//                "1xsq98",
//                "Hellakj",
//                "Doe",
//                null,
//                LocalDateTime.of(LocalDate.now(), LocalTime.now()),
//                LocalDateTime.of(LocalDate.now(), LocalTime.now()));
//
//        return List.of(group1);
        List<Groups> groups=groupRepository.findAll();
        return groupsMapping.convertListToListDto(groups,GroupsDto.class);
    }

    public void newGroup(Groups group) {
      groupRepository.save(group);
    }
}
