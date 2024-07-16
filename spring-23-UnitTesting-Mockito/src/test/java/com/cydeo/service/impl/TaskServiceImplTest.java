package com.cydeo.service.impl;

import com.cydeo.dto.TaskDTO;
import com.cydeo.entity.Task;
import com.cydeo.mapper.TaskMapper;
import com.cydeo.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TaskServiceImplTest {
    @Mock
    TaskRepository taskRepository;
    @Mock
    TaskMapper taskMapper;
    @InjectMocks
    TaskServiceImpl taskService;

    @ParameterizedTest
    @ValueSource(longs = {1L, 2L, 3L})
    void findById_Test(long id) {
// GIVEN
        Task task = new Task();

        when(taskRepository.findById(id)).thenReturn(Optional.of(task));
        when(taskMapper.convertToDto(task)).thenReturn(new TaskDTO());
// WHEN (ACTION IS HAPPENING)
        taskService.findById(id);
// THEN (ASSERTION and VERIFICATION CHECKS)
        verify(taskRepository).findById(id);
        verify(taskMapper).convertToDto(task);


    }

    @Test
    void findById_BBD_Test() {

        // GIVEN
        Task task = new Task();
        given(taskRepository.findById(anyLong())).willReturn(Optional.of(task));
        given(taskMapper.convertToDto(task)).willReturn(new TaskDTO());
        // WHEN
        taskService.findById(anyLong());
        // THEN
        then(taskRepository).should().findById(anyLong());
        then(taskMapper).should().convertToDto(task);


    }

}