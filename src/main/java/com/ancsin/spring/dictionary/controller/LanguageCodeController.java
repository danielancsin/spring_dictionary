package com.ancsin.spring.dictionary.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ancsin.spring.dictionary.entity.LanguageCode;
import com.ancsin.spring.dictionary.service.interfaces.LanguageCodeService;

@Controller
@RequestMapping("/langcodes")
public class LanguageCodeController {

	private LanguageCodeService languageCodeService;
	
	public LanguageCodeController(LanguageCodeService languageCodeService) {
		this.languageCodeService = languageCodeService;
	}

	@GetMapping({"","/"})
	public String list(Model model) {
		
		// get Users from db
		List<LanguageCode> results = languageCodeService.findAll();
		
		// add to the spring model
		model.addAttribute("users", results);
		
		return "/langcodes";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		
		// create model attribute to bind form data
		LanguageCode user = new LanguageCode();
		
		model.addAttribute("user", user);
		
		return "/langcodes-form";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("userId") long id, Model model) {
		
		// get the User from the service
		LanguageCode languageCode = languageCodeService.findById(id);
		
		// set User as a model attribute to pre-populate the form
		model.addAttribute("user", languageCode);
		
		// send over to our form
		return "/langcodes-form";			
	}
	
	
	@PostMapping("/save")
	public String save(@ModelAttribute("user") LanguageCode languageCode) {
		
		// save the User
		languageCodeService.save(languageCode);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/langcodes";
	}
	
	
	@GetMapping("/delete")
	public String delete(@RequestParam("userId") long id) {
		
		// delete the User
		languageCodeService.deleteById(id);
		
		return "redirect:/langcodes";
	}
	
	@GetMapping("/search")
	public String search(@RequestParam("name") String name, Model model) {
		
		// delete the User
		List<LanguageCode> languageCode = languageCodeService.searchBy(name);
		
		// add to the spring model
		model.addAttribute("languagecode", languageCode);
		
		return "/langcodes";
	}
}
