package com.bam.bamcoreport.repository;

import com.bam.bamcoreport.entity.ProfileMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileMemberRepository extends JpaRepository<ProfileMember,Long> {
}
