package com.bam.bamcoreport.repository;

import com.bam.bamcoreport.entity.Groups;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Groups,Long> {
}
