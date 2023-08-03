package com.lelecodev.userdept;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = "com.lelecodev.userdept.entities")
@SpringBootApplication
public class UserdeptApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserdeptApplication.class, args);
	}

}  
