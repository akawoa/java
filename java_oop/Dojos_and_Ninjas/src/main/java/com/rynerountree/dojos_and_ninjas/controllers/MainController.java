package com.rynerountree.dojos_and_ninjas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rynerountree.dojos_and_ninjas.models.Dojo;
import com.rynerountree.dojos_and_ninjas.models.Ninja;
import com.rynerountree.dojos_and_ninjas.services.MainService;




@Controller
public class MainController {
	
	@Autowired
	private MainService mainService;
	
	@GetMapping("/dojos/new")
	public String index(@ModelAttribute("dojoObj") Dojo emptyDojo) {
		return "dojos.jsp";
	}
	
	@PostMapping("/dojos/new")
	public String create(
			@ModelAttribute("userObj") Dojo filledDojo
	) {
		mainService.saveDojo(filledDojo);
		return "redirect:/";
	}
	
    @RequestMapping("/dojos/{id}")
    public String show(Model model,@PathVariable("id") Long id) {
        Dojo dojo = mainService.findDojo(id);
        model.addAttribute("dojo", dojo);
        return "/show.jsp";
    }
	
	@GetMapping("/ninjas/new")
	public String sales(
			@ModelAttribute("ninjasObj") Ninja emptyObj,
			Model model
	) {
		// GRAB ALL DOJOS FROM DB
		List<Dojo> allDojos = mainService.allDojos();
		// PASS THE DOJOS TO JSP
		model.addAttribute("dojos", allDojos);
		
		return "ninjas.jsp";
	}
	
	@PostMapping("/ninjas/new")
	public String createNinja(
			@ModelAttribute("ninjasObj") Ninja filledObj
	) {
		mainService.saveNinja(filledObj);
		return "redirect:/";
	}
	
	@GetMapping("/")
	public String ninjasDash(
			Model model
	) {
		// GRAB ALL EMPLOYEES FROM DB
		List<Dojo> allDojos = mainService.allDojos();
		// PASS THE EMPLOYESS TO JSP
		model.addAttribute("dojos", allDojos);
		return "dojoDash.jsp";
	}
	@GetMapping("/dojo/{id}/delete")
	public String deleteDojo(
			@PathVariable("id") Long dojo_id
			) {
		mainService.deleteDojo(dojo_id);
		return "redirect:/";
	}
	@GetMapping("/ninja/{id}/delete")
	public String deleteNinja(
			@PathVariable("id") Long ninja_id
			) {
		mainService.deleteNinja(ninja_id);
		return "redirect:/";
	}
	
	
}