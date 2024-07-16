package com.cydeo.service.impl;

import com.cydeo.mapper.UserMapper;
import com.cydeo.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    UserRepository userRepository;
    @Mock
    UserMapper userMapper;
    @InjectMocks
    UserServiceImpl userService; // when we test, we are calling the class itself not interface


    @Test
    void findByUserName_Test(){


        // I am calling the real method inside the main, which is the method I want to test
        userService.findByUserName("harold@manager.com");

        // I am checking if this method is working or not, just for verification
        verify(userRepository).findByUserNameAndIsDeleted("harold@manager.com",false);


        // Here we are verifying how many times this method called in the function,
        // in our real findByUserName method call only ones so test will fail
        verify(userRepository,times(1)).findByUserNameAndIsDeleted("harold@manager.com",false);

        // this verifies if this method called at least one in our function
        verify(userRepository, atLeastOnce()).findByUserNameAndIsDeleted("harold@manager.com",false);

        // other types of verifications we might consider using it

        verify(userRepository, atLeast(1)).findByUserNameAndIsDeleted("harold@manager.com",false);


        verify(userRepository, atMostOnce()).findByUserNameAndIsDeleted("harold@manager.com",false);

        verify(userRepository, atMost(5)).findByUserNameAndIsDeleted("harold@manager.com",false);


        // this will verify the order of the method execution
        InOrder inOrder=inOrder(userRepository,userMapper);


        inOrder.verify(userMapper).convertToDto(null);
        inOrder.verify(userRepository).findByUserNameAndIsDeleted("harold@manager.com",false);










    }

}