package com.bam.bamcoreport.repository;

import com.bam.bamcoreport.entity.Reject;
import com.bam.bamcoreport.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RejectRepository extends JpaRepository<Reject,Long> {
    Optional<Reject> findById(Long id);
}

