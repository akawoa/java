package com.rynerountree.thecode;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String index(HttpSession session) {
		
		session.setAttribute("secretCode", "bushido");
		
		return "code.jsp";
	}
	

	@RequestMapping(value="/process", method=RequestMethod.POST)
//	@PostMapping("/process")
	public String process(
			@RequestParam("password") String password,
			Model model,
			RedirectAttributes redirectAttributes,
			HttpSession session
	) {
		System.out.println(password);
		String secretWord = (String) session.getAttribute("secretCode");
		System.out.println(secretWord);
		if (password.equals(secretWord)) {
			System.out.println("display page");
			return "redirect:/correct";
		} else {
			System.out.println("You got it WRONG!");
			return "redirect:/createError";
		}
		}
	
	@RequestMapping("/correct")
	public String correct() {
		return "correct.jsp";
	}
	
    @RequestMapping("/createError")
    public String flashMessages(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("error", "Incorrect code word guess, try again!");
        return "redirect:/";
    }

}
