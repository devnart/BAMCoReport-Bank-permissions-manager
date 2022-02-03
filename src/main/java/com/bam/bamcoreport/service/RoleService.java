package com.bam.bamcoreport.service;

import com.bam.bamcoreport.dto.model.RoleDto;
import com.bam.bamcoreport.dto.services.IMapDto;
import com.bam.bamcoreport.entity.Role;
import com.bam.bamcoreport.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    IMapDto<Role, RoleDto> roleMapping;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<RoleDto> findAll(){
        List<Role> roles= roleRepository.findAll();
        return roleMapping.convertListToListDto(roles,RoleDto.class);
    }

    public void save(Role role){
        roleRepository.save(role);
    }


}
