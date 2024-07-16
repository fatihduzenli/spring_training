package com.cydeo.service.impl;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.entity.Project;
import com.cydeo.mapper.ProjectMapper;
import com.cydeo.repository.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProjectServiceImplTest {
    @Mock
    ProjectRepository projectRepository;
    @Mock
    ProjectMapper projectMapper;
    @InjectMocks
    ProjectServiceImpl projectService;

    @Test
    void getByProjectCode_Test() {

        // Here we say when we call projectRepository.findByProjectCode(anyString())  return new project entity --> this called Stubbing
        when(projectRepository.findByProjectCode(anyString())).thenReturn(new Project());

        // When we see projectMapper called with any Project entity, we return new projectDTO ==>Stubbing
        when(projectMapper.convertToDto(any(Project.class))).thenReturn(new ProjectDTO());

        // THis is when step
        ProjectDTO projectDTO = projectService.getByProjectCode(anyString());
        // This is then step
        InOrder inOrder = inOrder(projectRepository, projectMapper);  // I want to check the order if these 2 mock
        inOrder.verify(projectRepository).findByProjectCode(anyString());// we are providing in which order these 2 mock
        inOrder.verify(projectMapper).convertToDto(any(Project.class));

    }

    @Test
        // Here we will text if getByProjectCode runs with empty string, I want to throw exception
    void getByProjectCode_ExceptionTest() {
       // Here we are testing scenario if we pass empty string as a project code, are we getting NoSuchElementException
        when(projectRepository.findByProjectCode("")).thenThrow(new NoSuchElementException("Project Not Found"));

        // When we pass empty string in "projectService.getByProjectCode" we are expecting NoSuchElementException exception.
        Throwable throwable = assertThrows(NoSuchElementException.class, () -> projectService.getByProjectCode(""));


        // next 2 verification checks the place of the exception

        // Here we are varying if the String we passed in project code is really empty, that way we will know if we are getting the right exception
        verify(projectRepository).findByProjectCode("");

        //  we are verifying that conversion should never happen because we throw exception before this line
        verify(projectMapper, never()).convertToDto(any(Project.class));

        // we are checking if we are getting a correct exception message
        assertEquals("Project Not Found", throwable.getMessage());


    }


}