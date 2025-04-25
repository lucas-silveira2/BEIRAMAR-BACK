package com.beira.mar2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RestController
public class Beiramar2Application {

	public static void main(String[] args) {
		SpringApplication.run(Beiramar2Application.class, args);
	}
}