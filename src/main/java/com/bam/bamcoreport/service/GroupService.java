package com.bam.bamcoreport.service;

import com.bam.bamcoreport.entity.Groups;
import com.bam.bamcoreport.entity.Users;
import com.bam.bamcoreport.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {

    private final GroupRepository groupRepository;

    @Autowired
    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public List<Groups> getGroup() {
        return groupRepository.findAll();
    }
}
