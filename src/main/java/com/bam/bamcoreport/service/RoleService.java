package com.bam.bamcoreport.service;

import com.bam.bamcoreport.entity.Role;
import com.bam.bamcoreport.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {
    final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

 public List<Role> findAll(){
        return roleRepository.findAll();
    }

}
