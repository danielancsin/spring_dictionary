package com.ancsin.spring.dictionary.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ancsin.spring.dictionary.entity.Noun;
import com.ancsin.spring.dictionary.service.interfaces.NounService;

@Controller
@RequestMapping("/nouns")
public class NounController {

	private NounService nounService;

	public NounController(NounService nounService) {
		this.nounService = nounService;
	}
	
	@GetMapping("/")
	public String listNouns(Model model) {
		
		// get Nouns from db
		List<Noun> nouns = nounService.findAll();
		
		// add to the spring model
		model.addAttribute("nouns", nouns);
		
//		return "/nouns/list-nouns";
		return "/nouns";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		
		// create model attribute to bind form data
		Noun noun = new Noun();
		
		model.addAttribute("noun", noun);
		
		return "/noun-form";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("nounId") long id, Model model) {
		
		// get the Noun from the service
		Noun noun = nounService.findById(id);
		
		// set Noun as a model attribute to pre-populate the form
		model.addAttribute("noun", noun);
		
		// send over to our form
		return "/noun-form";			
	}
	
	
	@PostMapping("/save")
	public String saveNoun(@ModelAttribute("noun") Noun theNoun) {
		
		// save the Noun
		nounService.save(theNoun);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/nouns";
	}
	
	
	@GetMapping("/delete")
	public String delete(@RequestParam("nounId") long id) {
		
		// delete the Noun
		nounService.deleteById(id);
		
		// redirect to /Nouns/list
		return "redirect:/nouns";
		
	}
	
	@GetMapping("/search")
	public String search(@RequestParam("nounName") String name, Model model) {
		
		// delete the Noun
		List<Noun> nouns = nounService.searchBy(name);
		
		// add to the spring model
		model.addAttribute("nouns", nouns);
		
		// send to /Nouns/list
//		return "/nouns/list-nouns";
		return "/nouns";
		
	}
}
