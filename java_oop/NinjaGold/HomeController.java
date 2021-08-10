package com.rynerountree.ninjagold;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
		if (session.isNew()) {
	          session.setAttribute("totalGold", 0);

	          
	          ArrayList<String> activities = new ArrayList<String>();
	          session.setAttribute("activities", activities);
	          System.out.println(session.getAttribute("activities"));
	          
	          
	          //Create new arrayList to append to activities in session;
	          ArrayList<String> update = new ArrayList<String>();
	          update = (ArrayList<String>) session.getAttribute("activities");
	          System.out.println(update);
	          session.setAttribute("activities", update);
	          System.out.println(session.getAttribute("activities"));
	          
	       } else {
	    	  int currentGold = 0;
	         currentGold = (Integer)session.getAttribute("totalGold");	          
		       session.setAttribute("totalGold", currentGold);
		       
	       }
		return "index.jsp";
	}
	
	@RequestMapping(value="/process_money", method=RequestMethod.POST)
	public String process(
			@RequestParam("building") String choice,
			Model model,
			RedirectAttributes redirectAttributes,
			HttpSession session
			) {
  	  int currentGold = 0;
      currentGold = (Integer)session.getAttribute("totalGold");	          
//      session.setAttribute("totalGold", currentGold+=10);      
      System.out.println(choice);
		if (choice.equals("farm")) {
			int random_int = (int)Math.floor(Math.random()*(20-10+1)+10);
			System.out.println(random_int);
      		session.setAttribute("totalGold", currentGold+=random_int);
      		
      		
      		//Create timestamp String
    		Date date = new Date();
    		String strDateFormat = "hh:mm:ss a";
    		DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
    		String formattedDate = dateFormat.format(date);

    		String currentFormattedTime = formattedDate;
      		
      		
	        //Create new arrayList to append to activities in session;
	        ArrayList<String> update = new ArrayList<String>();
	        update = (ArrayList<String>) session.getAttribute("activities");
	        String output = String.format("Earned %s gold from the farm! %s", random_int, currentFormattedTime);
	        System.out.println(output);
	        update.add(output);
	        System.out.println(update);
	        session.setAttribute("activities", update);
	        System.out.println(session.getAttribute("activities"));
      		
      		
		} else if (choice.equals("cave")) {
			int random_int = (int)Math.floor(Math.random()*(10-5+1)+5);
			session.setAttribute("totalGold", currentGold+=random_int);
			
      		//Create timestamp String
    		Date date = new Date();
    		String strDateFormat = "hh:mm:ss a";
    		DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
    		String formattedDate = dateFormat.format(date);

    		String currentFormattedTime = formattedDate;
			
	        //Create new arrayList to append to activities in session;
	        ArrayList<String> update = new ArrayList<String>();
	        update = (ArrayList<String>) session.getAttribute("activities");
	        String output = String.format("Earned %s gold from the cave! %s", random_int, currentFormattedTime);
	        System.out.println(output);
	        update.add(output);
	        System.out.println(update);
	        session.setAttribute("activities", update);
	        System.out.println(session.getAttribute("activities"));			
			
		} else if (choice.equals("house")) {
			int random_int = (int)Math.floor(Math.random()*(5-2+1)+2);
			session.setAttribute("totalGold", currentGold+=random_int);
			
      		//Create timestamp String
    		Date date = new Date();
    		String strDateFormat = "hh:mm:ss a";
    		DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
    		String formattedDate = dateFormat.format(date);

    		String currentFormattedTime = formattedDate;
			
	        //Create new arrayList to append to activities in session;
	        ArrayList<String> update = new ArrayList<String>();
	        update = (ArrayList<String>) session.getAttribute("activities");
	        String output = String.format("Earned %s gold from the house! %s", random_int, currentFormattedTime);
	        System.out.println(output);
	        update.add(output);
	        System.out.println(update);
	        session.setAttribute("activities", update);
	        System.out.println(session.getAttribute("activities"));
			
		} else if (choice.equals("casino")) {
			int random_int = (int)Math.floor(Math.random()*(50-(-50)+1)+(-50));
			session.setAttribute("totalGold", currentGold+=random_int);
			
      		//Create timestamp String
    		Date date = new Date();
    		String strDateFormat = "hh:mm:ss a";
    		DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
    		String formattedDate = dateFormat.format(date);

    		String currentFormattedTime = formattedDate;
			
	        //Create new arrayList to append to activities in session;
	        ArrayList<String> update = new ArrayList<String>();
	        update = (ArrayList<String>) session.getAttribute("activities");
	        String output = String.format("Earned %s gold from the casino! %s", random_int, currentFormattedTime);
	        System.out.println(output);
	        update.add(output);
	        System.out.println(update);
	        session.setAttribute("activities", update);
	        System.out.println(session.getAttribute("activities"));
			
		}	
		
	return "redirect:/";
}
	
	
	
	
	
}
