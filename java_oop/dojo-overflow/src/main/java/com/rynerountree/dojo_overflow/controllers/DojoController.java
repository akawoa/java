package com.rynerountree.dojo_overflow.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rynerountree.dojo_overflow.models.Answer;
import com.rynerountree.dojo_overflow.models.Question;
import com.rynerountree.dojo_overflow.models.Tag;
import com.rynerountree.dojo_overflow.models.TagList;
import com.rynerountree.dojo_overflow.services.DojoService;

@Controller
public class DojoController {
	private final DojoService service;
	public DojoController(DojoService service) {
		this.service = service;
	}
	
	@RequestMapping("/questions")
	public String questions(Model model) {
		model.addAttribute("questions", service.allQuestions());
		return "questions.jsp";
	}
	@RequestMapping("/questions/new")
	public String addQuestionPage(@ModelAttribute("newQuestion") Question question) {
		return "newQuestion.jsp";
	}
	@PostMapping("/questions/new")
	public String addQuestion(@ModelAttribute("newQuestion") Question question, BindingResult result, @RequestParam(value="tagList") String tags) {
		if(result.hasErrors()) {
			return "newQuestion.jsp";
		}
		TagList list = new TagList(tags);
		Question savedQuestion = service.addQuestion(question);
		for(String val:list.getTags()) {
			if(service.allTagNames().contains(val) == false) {
				Tag savedTag = service.addTag(new Tag(val));
				service.addQuestionTag(savedQuestion, savedTag);
			} else {
				service.addQuestionTag(savedQuestion, service.findTagByName(val));
			}
		}
		return "redirect:/questions/new";
	}
//	@RequestMapping("/questions/{id}")
//	public String showQuestion(@PathVariable("id") Long id, Model model, @ModelAttribute("newAnswer") Answer answer) {
//		model.addAttribute("question", service.findQuestion(id));
//		for(Answer val:service.findQuestion(id).findAnswer()) {
//			System.out.println(val.getAnswer());
//		}
//		
//		return "question";
//	}
//	@PostMapping("/questions/{id}")
//	public String addAnswer(@ModelAttribute("newAnswer") Answer answer, BindingResult result, @PathVariable("id") Long id, Model model) {
//		if(result.hasErrors()) {
//			model.addAttribute("question", service.findQuestion(id));
//			return "question.jsp";
//		}
//		
//		Answer ans = service.addAnswer(new Answer(answer.getAnswer()));
//		service.addAnswerToQuestion(ans, service.findQuestion(id));
//		
//		return "redirect:/questions/{id}";
//	}
}