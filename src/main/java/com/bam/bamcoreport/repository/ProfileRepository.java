package com.bam.bamcoreport.repository;

import com.bam.bamcoreport.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ProfileRepository extends JpaRepository<Profile,Long> {
    Optional<Profile> findByName(String name);
}
