package com.cydeo.controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(WelcomeController.class)
public class WelcomeControllerTest {


    @Autowired
    private MockMvc mvc;
    // MockMvc is used to perform HTTP requests in a Spring MVC test environment.


    @Test
    void welcome_Test() throws Exception {
        // 1. step call /welcome endpoint
        // 2. step verify response is "welcome"


        //Creates a GET request to the /welcome endpoint.
        RequestBuilder request = MockMvcRequestBuilders.get("/welcome")
                .accept(MediaType.APPLICATION_JSON); //Specifies that the client accepts responses in JSON format.


        //Declares a variable named result to hold the result of the request.
        //Performs the request using the MockMvc instance Returns the result of the request execution.
        MvcResult result = mvc.perform(request).andReturn();

        assertEquals(200, result.getResponse().getStatus());
        assertEquals("welcome", result.getResponse().getContentAsString());

    }


    @Test
    void welcome_Test2() throws Exception {
        // same thing as above but much more clean and useful.

        RequestBuilder request=MockMvcRequestBuilders.get("/welcome")
                .accept(MediaType.APPLICATION_JSON);

        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("welcome"))
                .andReturn();



    }

}








