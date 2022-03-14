package com.bam.bamcoreport.service;

import com.bam.bamcoreport.dto.model.UserDto;
import com.bam.bamcoreport.dto.services.IMapDto;
import com.bam.bamcoreport.entity.Users;
import com.bam.bamcoreport.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class UserServiceTest {

    @InjectMocks
    UserService userService;

    @Mock
    UserRepository userRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getUsers() {
        List<Users> list=new ArrayList<>();

        Users user= new Users(3L,
                "salma",
                "1xsq98",
                "John",
                "Doe",
                "CEO",
                "head of everything",
                null,
                null,
                LocalDate.of(1980, 1, 1),
                LocalDate.of(1980, 1, 1));

        Users user2= new Users(3L,
                "salma",
                "1xsq98",
                "John",
                "Doe",
                "CEO",
                "head of everything",
                null,
                null,
                LocalDate.of(1980, 1, 1),
                LocalDate.of(1980, 1, 1));

        list.add(user);
        list.add(user2);

        when(userRepository.findAll()).thenReturn(list);
        assertThat(userRepository.findAll()).isNotNull();

    }

}