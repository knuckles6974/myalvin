package com.example.myalvin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class MyalvinApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyalvinApplication.class, args);


	}


}
