package com.bam.bamcoreport.controller;

import com.bam.bamcoreport.entity.Users;
import com.bam.bamcoreport.repository.UserRepository;
import com.bam.bamcoreport.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserControllerTest {

    @Autowired
    private UserService service;

    @MockBean
    private UserRepository repository;

    @Test
    public void getUsersTest(){
        when(repository.findAll()).thenReturn(Stream.of(
                (new Users("johndoe",
                        "1xsq98",
                        "John",
                        "Doe",
                        "CEO",
                        "head of everything",
                        null,
                        null,
                        LocalDate.of(1980, 1, 1),
                        LocalDate.of(1980, 1, 1))
        )).collect(Collectors.toList()));
        assertEquals(1,service.getUsers().size());
    }

    @Test
    public void saveUserTest(){
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
        when(repository.save(user)).thenReturn(user);
        assertEquals(user, service.newUser(user));
    }

    @Test
    public void deleteUserTest(){
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
        repository.delete(user);
       // verify(repository, times(1)).delete(user);
    }


}