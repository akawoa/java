package com.rynerountree.counter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/black_lagoon")
public class HomeController {

	
	@RequestMapping("")
    public String index(HttpSession session) {
	      if (session.isNew()) {
	          session.setAttribute("countToShow", 0);
	       } else {
	    	  int visitCount = 0;
	          visitCount = (Integer)session.getAttribute("countToShow");
	          visitCount = visitCount + 1;
		       session.setAttribute("countToShow", visitCount);
	       }
		return "index.jsp";
	}

	@RequestMapping("/counter")
	public String date(HttpSession session, Model model) {
        Integer currentCount = (Integer) session.getAttribute("countToShow");
        model.addAttribute("count", currentCount);
		return "counter.jsp";
	}

	@RequestMapping("/reset")
	public String time(HttpSession session) {
			session.setAttribute("countToShow", 0);
		return "redirect:/black_lagoon/counter";
	}
	
	
}
