package com.bam.bamcoreport.repository;

import com.bam.bamcoreport.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {


}
