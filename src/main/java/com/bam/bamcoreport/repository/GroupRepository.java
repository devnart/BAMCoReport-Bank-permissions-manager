package com.bam.bamcoreport.repository;

import com.bam.bamcoreport.entity.Groups;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GroupRepository extends JpaRepository<Groups,Long> {
    @Override
    <S extends Groups> Optional<S> findOne(Example<S> example);
}
