package com.rynerountree.displaydate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String index(Model model) {

		String firstName = "Ada";
		String lastName = "Lovelace";
		String email = "ones@zeroes.com";
		Integer age = 160;

		model.addAttribute("first", firstName);
		model.addAttribute("last", lastName);
		model.addAttribute("email", email);
		model.addAttribute("age", age);

		return "index.jsp";
	}

	@RequestMapping("/date")
	public String date(Model model) {

		Date date = new Date();
		String strDateFormat = "hh:mm:ss a";
		DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
		SimpleDateFormat DateFor = new SimpleDateFormat("MM/dd/yyyy");
		String stringDate = DateFor.format(date);
		DateFor = new SimpleDateFormat("EEEE, dd MMM yyyy");
		stringDate = DateFor.format(date);

		String currentformattedDate = stringDate;

		model.addAttribute("date", currentformattedDate);

		return "date.jsp";
	}

	@RequestMapping("/time")
	public String time(Model model) {
		Date date = new Date();
		String strDateFormat = "hh:mm:ss a";
		DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
		String formattedDate = dateFormat.format(date);

		String currentformattedTime = formattedDate;

		model.addAttribute("time", currentformattedTime);

		return "time.jsp";
	}
}
