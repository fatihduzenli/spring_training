package com.cydeo.controller;

import com.cydeo.client.EmployeeClient;
import com.cydeo.client.UserClient;
import com.cydeo.dto.ResponseWrapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Consume_FeignClient {
    private final UserClient userClient;
    // we inject this interface to use the method that has the list of users (list that we consumed)
    private final EmployeeClient employeeClient;

    public Consume_FeignClient(UserClient userClient, EmployeeClient employeeClient) {
        this.userClient = userClient;
        this.employeeClient = employeeClient;
    }

    @GetMapping("/api/v1/users")
    public ResponseEntity<ResponseWrapper> getUsers() {
        return ResponseEntity.ok(new ResponseWrapper("UserList retrieved", userClient.getUsers()));
        // as a parameter, we pass a message and the api body. Api body is the method has the consumed api
    }
    @GetMapping("/api/v1/employee")
    public  ResponseEntity<ResponseWrapper>getEmployee(){
        return ResponseEntity.ok(new ResponseWrapper("Employee Retrieved",employeeClient.getEmployee("6298ebfecd0551211fce37a6")));
    }
}
