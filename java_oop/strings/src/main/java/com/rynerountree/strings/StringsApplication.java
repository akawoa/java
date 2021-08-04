package com.rynerountree.strings;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class StringsApplication {

	public static void main(String[] args) {
		SpringApplication.run(StringsApplication.class, args);
	}
	
	@RequestMapping("/")
	public String hello() {
		return "Hello Darling, we're part of a greater consciousness now ~";
	}

	@RequestMapping("/random")
	public String random() {
		return "Spring Boot is keeping us alive, Dar-ling";
	}

	
}