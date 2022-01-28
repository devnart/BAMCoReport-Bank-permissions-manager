package com.bam.bamcoreport.config;


import com.bam.bamcoreport.entity.Role;
import com.bam.bamcoreport.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Calendar;

@Configuration
public class RoleConfig {

    @Bean
    CommandLineRunner commandLineRunner(RoleRepository roleRepository){
        return args -> {
            roleRepository.save(new Role("ROLE_ADMIN", "Administrator","Administrator description",null));

        };
    }
}
