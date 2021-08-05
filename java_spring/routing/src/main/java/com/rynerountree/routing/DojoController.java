package com.rynerountree.routing;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DojoController {

	
	@RequestMapping("/{dojo}")
	public String dojo(@PathVariable("dojo") String dojo) {
		return "The " + dojo + " is awesome!";
	}
	
	@RequestMapping("/{location}-dojo/")
	public String locationDojo(@PathVariable("location") String location) {
		String capitalized1 = location.substring(0, 1).toUpperCase() + location.substring(1);
		System.out.println(capitalized1);
		return capitalized1 + " Dojo is located in Southern California.";
	}
	
	@RequestMapping("/{location}/")
	public String headquarters(@PathVariable("location") String location) {
		String secondLetter = "";
		int letterIndex = 0;
		String firstLetter = location.substring(0, 1).toUpperCase() + location.substring(1);
		
		while (letterIndex < location.length()) {
			if (location.substring(letterIndex) == "-") {
				secondLetter = location.substring(letterIndex+1);
				letterIndex = location.length();
				return secondLetter;
			} else {
				letterIndex++;
			}
		}
		
		return firstLetter + secondLetter + " dojo is the headquarters.";
	}
	
}



//
//Have an http GET request to 'http://localhost:8080/dojo' display a text that says 'The dojo is awesome!'.
//Have an http GET request to 'http://localhost:8080/burbank-dojo/' display a text that says 'Burbank Dojo is located in Southern California'.
//Have an http GET request to 'http://localhost:8080/san-jose/' display a text that says 'SJ dojo is the headquarters'.
//
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//@RestController
//public class HomeController {
//    @RequestMapping("/m/{track}/{module}/{lesson}")
//    public String showLesson(@PathVariable("track") String track, @PathVariable("module") String module, @PathVariable("lesson") String lesson){
//    	return "Track: " + track + ", Module: " + module + ", Lesson: " + lesson;
//    }
//}