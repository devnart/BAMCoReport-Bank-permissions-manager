package com.bam.bamcoreport.controller;

import com.bam.bamcoreport.dto.model.RoleDto;
import com.bam.bamcoreport.entity.Role;
import com.bam.bamcoreport.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/role")
public class RoleController {

    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }



    @GetMapping
    public List<RoleDto> getAllRoles() {
        return roleService.findAll();
    }

    @PostMapping
    public void createRole(@RequestBody Role role) {
         roleService.save(role);
    }

}

