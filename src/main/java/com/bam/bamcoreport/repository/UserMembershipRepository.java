package com.bam.bamcoreport.repository;

import com.bam.bamcoreport.entity.UserMembership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMembershipRepository extends JpaRepository<UserMembership,Long> {
    UserMembership findByUserId(Long userId);
}
