package com.example.ResgisterLogin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)

public class ResgisterLoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResgisterLoginApplication.class, args);
	}

}
