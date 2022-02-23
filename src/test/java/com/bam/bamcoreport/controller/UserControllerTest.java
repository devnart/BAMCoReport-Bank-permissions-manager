package com.bam.bamcoreport.controller;

import com.bam.bamcoreport.dto.model.UserDto;
import com.bam.bamcoreport.entity.Users;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
class UserControllerTest {

    @Autowired
    @Mock
    private UserController userController;

    @Test
    public void getUsersTest(){
        List<UserDto> users = userController.getUsers();
        assertThat(users).isNotNull();
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
        Users saveUser = userController.addUser(user);
        assertThat(saveUser).isNotNull();
    }
}