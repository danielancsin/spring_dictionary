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
	
	// TODO : pagination, BUT huge performance impact on small (500k words) table. Optimze query, etc...
	// TODO : user settings pased pagination
//	@GetMapping("/{pageNo}/{pageSize}")
	@GetMapping({"","/"})
    public String listNounsPaginated(
//    		@PathVariable(required = false) int pageNo, 
//            @PathVariable(required = false) int pageSize,
    		@RequestParam(required = false, defaultValue = "0") int pageNo,
    		@RequestParam(required = false, defaultValue = "20") int pageSize,
            Model model
            ) {
		List<Noun> nouns = nounService.findAllPaginated(pageNo, pageSize);
		
		model.addAttribute("nouns", nouns);
		
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
		
		// send over to form
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
		
		return "redirect:/nouns";
	}
	
	@GetMapping("/search")
	public String search(@RequestParam("word") String word, Model model) {
		
		List<Noun> nouns = null;

		if (word.strip().isEmpty())
			nouns = nounService.findAll();
		else
			nouns = nounService.searchBy(word);
		
		// add to the spring model
		model.addAttribute("nouns", nouns);
		
		return "/nouns";
	}
}
