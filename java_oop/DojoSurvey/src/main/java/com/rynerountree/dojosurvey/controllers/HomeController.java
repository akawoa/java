package com.rynerountree.dojosurvey.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String index(HttpSession session) {
		
		return "index.jsp";
	}
	
	@RequestMapping(value="/result", method=RequestMethod.POST)
//	@PostMapping("/process")
	public String process(
			@RequestParam("name") String name,
			@RequestParam("location") String location,
			@RequestParam("language") String language,
			@RequestParam("comment") String comment,
			Model model,
			RedirectAttributes redirectAttributes,
			HttpSession session
	) {
		session.setAttribute("name", name);
		session.setAttribute("location", location);
		session.setAttribute("language", language);
		session.setAttribute("comment", comment);
		return "code.jsp";
		
		}
	
	@RequestMapping("/display")
	public String display() {
		return "code.jsp";
	}
	
//    @RequestMapping("/createError")
//    public String flashMessages(RedirectAttributes redirectAttributes) {
//        redirectAttributes.addFlashAttribute("error", "Incorrect code word guess, try again!");
//        return "redirect:/";
//    }
	
}
