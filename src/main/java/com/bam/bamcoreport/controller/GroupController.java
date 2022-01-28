package com.bam.bamcoreport.controller;

import com.bam.bamcoreport.entity.Groups;
import com.bam.bamcoreport.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/group")
public class GroupController {

    private final GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping
    public List<Groups> getGroup() {
        return groupService.getGroup();
    }

    @PostMapping
    public void addGroup(@RequestBody Groups group){
        groupService.newGroup(group);
    }
}
