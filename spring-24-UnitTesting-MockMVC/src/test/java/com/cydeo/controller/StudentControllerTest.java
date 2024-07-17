package com.cydeo.controller;

import com.cydeo.dto.StudentDTO;
import com.cydeo.service.StudentService;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(StudentController.class)
public class StudentControllerTest {

    @Autowired
    private MockMvc mvc;
    @MockBean
    private StudentService studentService;

  @Test
    void getStudent_Test() throws Exception {

      mvc.perform(MockMvcRequestBuilders.get("/student")
              .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
              .andExpect(content().json("{\"firstName\": \"Mike\", \"lastName\":  \"Smith\", \"age\": 20}"))
              .andDo(print()) // this will print it on the console
              .andReturn();
  }


}
