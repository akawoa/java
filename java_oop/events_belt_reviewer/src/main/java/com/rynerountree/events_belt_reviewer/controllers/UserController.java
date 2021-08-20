package com.rynerountree.events_belt_reviewer.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rynerountree.events_belt_reviewer.models.User;
import com.rynerountree.events_belt_reviewer.services.UserService;
import com.rynerountree.events_belt_reviewer.validators.UserValidator;

@Controller
public class UserController {
	@Autowired
	private UserService userServ;
	
	@Autowired
	private UserValidator userValidator;
	
    @GetMapping("/")
    public String loginRegistrationHome(@ModelAttribute("userObj") User emptyUser) {
        return "logRegHome.jsp";
    }
    
	
	@GetMapping("/registration")
    public String registerForm(@ModelAttribute("userObj") User emprtyUser) {
        return "registrationPage.jsp";
    }
    @GetMapping("/login")
    public String login() {
        return "loginPage.jsp";
    }
    
    
    @PostMapping("/registration")
    public String registerUser(
    		@Valid @ModelAttribute("userObj") User filledUser, BindingResult result, 
    		HttpSession session
    ) {
    	userValidator.validate(filledUser, result);
        // if result has errors, return the registration page (don't worry about validations just now)
    	if(result.hasErrors()) {
    		return "registrationPage.jsp";
    	}
        // else, save the user in the database, save the user id in session, and redirect them to the /home route
    	else {
    		User newUser = userServ.registerUser(filledUser);
    		session.setAttribute("user_id", newUser.getId());
    		session.setAttribute("firstName", newUser.getFirstName());
    		session.setAttribute("state", newUser.getState());
    		//This endpoint should be wherever your dashboard is located
    		return "redirect:/home";
    	}
    }
    
    @PostMapping("/login")
    public String loginUser(
    		@RequestParam("email") String email, @RequestParam("password") String password, 
    		Model model, 
    		HttpSession session,
    		RedirectAttributes flashMessages
    ) {
        // if the user is authenticated, save their user id in session
    	if(userServ.authenticateUser(email, password)) {
    		User loggedUser = userServ.findByEmail(email);
    		session.setAttribute("user_id", loggedUser.getId());
    		//This endpoint should be wherever your dashboard is located
    		return "redirect:/home";
    	}
        // else, add error messages and return the login page
    	else {
    		flashMessages.addFlashAttribute("error", "INVALID LOGIN");
    		return "redirect:/login";
    	}
    }
    
    @RequestMapping("/home")
    public String home(HttpSession session, Model model) {
        // get user from session, save them in the model and return the home page
    	Long user_id = (Long) session.getAttribute("user_id");
    	User u = userServ.findUserById(user_id);
    	model.addAttribute("user", u);
		//This endpoint should be wherever your dashboard JSP file is located
    	return "homePage.jsp";
    }
	
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        // invalidate session
        // redirect to login page
    	session.invalidate();
    	return "redirect:/";
    }
    
    
    @PostMapping("/registration/process")
    public String registerUserProcess(
    		@Valid @ModelAttribute("userObj") User filledUser, BindingResult result, 
    		HttpSession session
    ) {
    	userValidator.validate(filledUser, result);
        // if result has errors, return the registration page (don't worry about validations just now)
    	if(result.hasErrors()) {
    		return "logRegHome.jsp";
    	}
        // else, save the user in the database, save the user id in session, and redirect them to the /home route
    	else {
    		User newUser = userServ.registerUser(filledUser);
    		session.setAttribute("user_id", newUser.getId());
    		//This endpoint should be wherever your dashboard is located
    		return "redirect:/events";
    	}
    }
    
    @PostMapping("/login/process")
    public String loginUserProcess(
    		@RequestParam("email") String email, @RequestParam("password") String password, 
    		Model model, 
    		HttpSession session,
    		RedirectAttributes flashMessages
    ) {
        // if the user is authenticated, save their user id in session
    	if(userServ.authenticateUser(email, password)) {
    		User loggedUser = userServ.findByEmail(email);
    		session.setAttribute("user_id", loggedUser.getId());
    		//This endpoint should be wherever your dashboard is located
    		return "redirect:/events";
    	}
        // else, add error messages and return the login page
    	else {
    		flashMessages.addFlashAttribute("error", "INVALID LOGIN");
    		return "redirect:/";
    	}
    }
    
    
    
	
}
