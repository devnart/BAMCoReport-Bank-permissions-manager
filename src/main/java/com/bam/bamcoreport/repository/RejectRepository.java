package com.bam.bamcoreport.repository;

import com.bam.bamcoreport.entity.Reject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RejectRepository extends JpaRepository<Reject,Long> {
}
