package com.bam.bamcoreport.config;

import com.bam.bamcoreport.entity.Users;
import com.bam.bamcoreport.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class UserConfig {

//    @Bean
   /* CommandLineRunner commandLineRunner(UserRepository repository) {
        return args -> {
            Users john = new Users(
                    "johndoe",
                    "1xsq98",
                    "John",
                    "Doe",
                    "CEO",
                    "head of everything",
                    null,
                    null,
                    LocalDate.of(1980, 1, 1),
                    LocalDate.of(1980, 1, 1));

            Users dua = new Users(
                    "johndoe",
                    "1xsq98",
                    "Dua",
                    "Lupa",
                    "CEO",
                    "head of everything",
                    john,
                    john,
                    LocalDate.of(1980, 1, 1),
                    LocalDate.of(1980, 1, 1));

            repository.saveAll(List.of(john,dua));
        };


    }*/
}
