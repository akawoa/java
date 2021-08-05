package com.rynerountree.hellohuman;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/your_server/")
public class HumanController {
	
	@RequestMapping("")
	public String inputNameWelcome(@RequestParam(value="q", required = false) String searchQuery) {
		
		if (searchQuery == null) {		
		return "Hello Human! Welcome to Spring Boot ^_^";
		} else {
			return "Hello " + searchQuery + "! Welcome to Spring Boot ^_-";
		}		
	}
	
}
