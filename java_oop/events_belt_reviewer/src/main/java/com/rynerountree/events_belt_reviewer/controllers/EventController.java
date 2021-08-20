package com.rynerountree.events_belt_reviewer.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rynerountree.events_belt_reviewer.models.Event;
import com.rynerountree.events_belt_reviewer.models.User;
import com.rynerountree.events_belt_reviewer.services.EventService;
import com.rynerountree.events_belt_reviewer.services.UserService;





@Controller
public class EventController {
	
	@Autowired
	private UserService userServ;
	
	@Autowired
	private EventService eventService;
	
	
	// -------------------- VIEW DATA ---------------------------//	
    @GetMapping("/events")
    public String eventDashboard(HttpSession session, @ModelAttribute("eventObj") Event emptyObj,
    		Model model,
    		RedirectAttributes flashMessages) {
    	//CHECK TO SEE IF A USER IS LOGGED IN
    	if(session.getAttribute("user_id") == null) {
    		flashMessages.addFlashAttribute("error", "YOU MUST BE LOGGED IN TO ACCESS THE PAGE");
    		return "redirect:/";    		
    	}
    	
        // get user from session, save them in the model and return the home page
    	Long user_id = (Long) session.getAttribute("user_id");
    	User u = userServ.findUserById(user_id);
    	model.addAttribute("user", u);
    	
		// GRAB ALL EVENTS FROM DB
    	List<Event> allEvents = eventService.allEvents();
    	// PASS THE EVENTS TO JSP
    	model.addAttribute("events", allEvents);    	
    	
		//This endpoint should be wherever your dashboard JSP file is located
    	return "eventDashboard.jsp";
    }
    
    @RequestMapping("/events/{id}")
    public String show(Model model,@PathVariable("id") Long id,
    		HttpSession session, RedirectAttributes flashMessages) {
    	//CHECK TO SEE IF A USER IS LOGGED IN
    	if(session.getAttribute("user_id") == null) {
    		flashMessages.addFlashAttribute("error", "YOU MUST BE LOGGED IN TO ACCESS THE PAGE");
    		return "redirect:/";    		
    	}
        // get user from session, save them in the model and return the home page
    	Long user_id = (Long) session.getAttribute("user_id");
    	User currentUser = userServ.findUserById(user_id);
    	model.addAttribute("user", currentUser);
    	//Find the event in the database
        Event event = eventService.findEvent(id);
        model.addAttribute("event", event);
        return "eventShow.jsp";
    }

 // -------------------- VIEW DATA ---------------------------//
    
 // -------------------- CREATE DATA ---------------------------//
    
	@PostMapping("/events/new")
	public String createEvent(@Valid @ModelAttribute("eventObj") Event filledObj, BindingResult result, HttpSession session, Model model) {
    	if (result.hasErrors()) {
            // get user from session, save them in the model and return the home page
        	Long user_id = (Long) session.getAttribute("user_id");
        	User u = userServ.findUserById(user_id);
        	model.addAttribute("user", u);
    		// GRAB ALL EVENTS FROM DB
        	List<Event> allEvents = eventService.allEvents();
        	// PASS THE EVENTS TO JSP
        	model.addAttribute("events", allEvents);    	
				return "/eventDashboard.jsp";
    	} else {
    		eventService.saveEvent(filledObj);
    		return "redirect:/events";
    	}
	}	

//	@PostMapping("/join/new")
//	public String attendEvent(@ModelAttribute("joinEventObj") JoinEvent filledJoinEvent) {
//		joinEventServ.saveJoinEvent(filledJoinEvent);
//		return "redirect:/events";
//	}
	
 // -------------------- CREATE DATA ---------------------------//

	 // -------------------- UPDATE DATA ---------------------------//
	
	
    @GetMapping("/events/{id}/edit")
    public String editEvent(@PathVariable("id") Long id,HttpSession session, Model model) {
        Event event = eventService.findEvent(id);
     // get user from session, save them in the model and return the home page
    	Long user_id = (Long) session.getAttribute("user_id");
    	User currentUser = userServ.findUserById(user_id);
    	model.addAttribute("user", currentUser);
    	if (event.getUser().equals(currentUser)) {
        model.addAttribute("event", event);
        return "eventEdit.jsp";
    	} else {
    		return "redirect:/events";
    	}
    }
	
    @PutMapping("/events/{id}")
    public String update(@Valid @ModelAttribute("event") Event filledEvent, BindingResult result) {
    	// VALIDATIONS FAIL, RERENDER THE JSP
    	if (result.hasErrors()) {        
            return "eventEdit.jsp";
        } else {
        	// VALIDATIONS PASS, CREATE THE EVENT
            eventService.updateEvent(filledEvent);
            return "redirect:/events";
        }
    }
	//CREATING THE RELATIONSHIP BETWEEN THE EVENTS AND USERS
    @GetMapping("/events/{id}/attend")
	public String addUserToEvent(
			HttpSession session,
			Model model,
			@PathVariable("id")Long event_id
	) {
        // get user from session, save them in the model and return the home page
    	Long user_id = (Long) session.getAttribute("user_id");
    	User currentUser = userServ.findUserById(user_id);
    	model.addAttribute("user", currentUser);
		// USING THE IDS, FIND USER AND EVENT OBJ
		Event oneEvent = eventService.findEvent(event_id);
		// ADD THE RELATIONSHIP TO THE OBJECTS
		oneEvent.getUsersAttending().add(currentUser);		
		// SAVE THE NEW INFORMATION IN THE DB
		eventService.saveEvent(oneEvent);
		return "redirect:/events";		
	}

	//DELETING THE RELATIONSHIP BETWEEN THE EVENTS AND USERS
    @GetMapping("/events/{id}/cancel")
	public String removeUserFromEvent(
			HttpSession session,
			Model model,
			@PathVariable("id")Long event_id
	) {
        // get user from session, save them in the model and return the home page
    	Long user_id = (Long) session.getAttribute("user_id");
    	User currentUser = userServ.findUserById(user_id);
    	model.addAttribute("user", currentUser);
		// USING THE IDS, FIND USER AND EVENT OBJ
		Event oneEvent = eventService.findEvent(event_id);
		// ADD THE RELATIONSHIP TO THE OBJECTS
		oneEvent.getUsersAttending().remove(currentUser);		
		// SAVE THE NEW INFORMATION IN THE DB
		eventService.saveEvent(oneEvent);
		return "redirect:/events";		
	}

	
	 // -------------------- UPDATE DATA ---------------------------//
	
	
	 // -------------------- DELETE DATA ---------------------------//
	
	@GetMapping("/events/{id}/delete")
	public String deleteEvent(
			@PathVariable("id") Long event_id, HttpSession session, RedirectAttributes flashMessages,Model model) {
		//CHECK TO SEE IF A USER IS LOGGED IN
    	if(session.getAttribute("user_id") == null) {
    		flashMessages.addFlashAttribute("error", "YOU MUST BE LOGGED IN TO ACCESS THE PAGE");
    		return "redirect:/";    		
    	} else {
    	 Event event = eventService.findEvent(event_id);
         // get user from session, save them in the model and return the home page
        	Long user_id = (Long) session.getAttribute("user_id");
        	User currentUser = userServ.findUserById(user_id);
        	model.addAttribute("user", currentUser);
    	if (event.getUser().equals(currentUser)) {
    		eventService.deleteEvent(event_id);
    		return "redirect:/events";
    	} else {
    		return "redirect:/events";
    	}
    	}
		
	
	}
	
	 // -------------------- DELETE DATA ---------------------------//
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
