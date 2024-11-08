package com.cydeo.controller;

import com.cydeo.dto.User;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
@RequestMapping("/cydeo")
public class Consume_RestTemplate {

    private final String URI = "https://jsonplaceholder.typicode.com/users";
    private final RestTemplate restTemplate;

    public Consume_RestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping  // now we consumed json file from a different source to our end point.
    public ResponseEntity<User[]> readAllUsers() {

        return restTemplate.getForEntity(URI, User[].class);
        // getForEntity is asking 2 parameters; one is URL,
        // sec is the dto that we converted from json, this method accepts the user as an Array class
    }
    @GetMapping("{id}")
    public Object readUser(@PathVariable("id") Integer id){
        String URL= URI+"/id";
        return restTemplate.getForObject(URL, Object.class,id);
    }
    // diff between getForEntity and getForObject is: with getForEntity we can go to DTO class and modify it
    // but with getForObject we cannot modify it whatever is there we use it
@GetMapping("/test")
    public  ResponseEntity<Object>consumePostFromDummyApi(){

        HttpHeaders headers =new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.set("app-id","6298ebfecd0551211fce37a6");

        HttpEntity<String> entity = new HttpEntity<>(headers);

        return restTemplate.exchange("https://dummyapi.io/data/v1/user?limit=10", HttpMethod.GET,entity,Object.class);
        // we use exchange method when we need to provide headers
    }
}
