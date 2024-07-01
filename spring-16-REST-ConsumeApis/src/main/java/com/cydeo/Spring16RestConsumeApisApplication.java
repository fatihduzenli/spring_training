package com.cydeo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@SpringBootApplication
@EnableFeignClients
public class Spring16RestConsumeApisApplication {

	public static void main(String[] args) {
		SpringApplication.run(Spring16RestConsumeApisApplication.class, args);
	}
	@Bean
public RestTemplate restTemplate(){  // THIS COMING WITH SPRING FRAMEWORK

		return new RestTemplate();
	}

}
