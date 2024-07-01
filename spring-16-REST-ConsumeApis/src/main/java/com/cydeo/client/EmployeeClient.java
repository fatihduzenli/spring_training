package com.cydeo.client;

import com.cydeo.dto.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(url="https://dummyapi.io",name = "EMPLOYEE-CLIENT")
public interface EmployeeClient {
    @GetMapping("/data/v1/user?limit=10")
    Employee getEmployee(@RequestHeader("app-id") String id);
    // whenever I call this method url on the top will be executed. This is like container has the Api that we are consuming
}
