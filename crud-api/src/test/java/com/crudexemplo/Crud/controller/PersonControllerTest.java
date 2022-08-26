package com.crudexemplo.Crud.controller;

import com.crudexemplo.Crud.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith((MockitoExtension.class))
public class PersonControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;


    @BeforeEach
    public void setup() {
    }

    @Test
    public void shouldReturnSuccess_WhenCreateUser() {

    }
}
