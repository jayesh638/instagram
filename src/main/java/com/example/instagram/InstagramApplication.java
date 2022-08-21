package com.example.instagram;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InstagramApplication {

	public static void main(String[] args) {
		System.out.println("running");
		SpringApplication.run(InstagramApplication.class, args);
	}

}
