package com.ancsin.spring.dictionary.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
	
	// TODO : user settings pased pagination
	public static final int DEFAULT_PAGE = 0;
	public static final int DEFAULT_PAGE_SIZE = 20;
	public static final int DEFAULT_PAGINATION = 6;

	private NounService nounService;

	public NounController(NounService nounService) {
		this.nounService = nounService;
	}
	
	// TODO : pagination, BUT huge performance impact on small (500k words) table. Optimze query, etc...
	@GetMapping({"","/", "/search"})
    public String listNounsPaginated(
    		@PageableDefault(size = DEFAULT_PAGE_SIZE, page = DEFAULT_PAGE) Pageable pageable,
    		@RequestParam(required = false) String word,
    		Model model
            ) {
		
		Page<Noun> nounPage = null;
		
		if (word == null || word.strip().isEmpty())
			nounPage = nounService.findAllPaginated(pageable);
		else
			nounPage = nounService.findByWordContainsAllIgnoreCase(word, pageable);
		
		int current = nounPage.getNumber() + DEFAULT_PAGINATION / 2;
	    int begin = Math.max(0, current - DEFAULT_PAGINATION);
	    int end = Math.min(begin + DEFAULT_PAGINATION, nounPage.getTotalPages());
		
		model.addAttribute("nounPage", nounPage);
		model.addAttribute("current", current);
		model.addAttribute("begin", begin);
		model.addAttribute("end", end);
		model.addAttribute("searchedWord", word);
		
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
	public String saveNoun(@ModelAttribute("noun") Noun noun) {
		
		// save the Noun
		nounService.save(noun);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/nouns";
	}
	
	
	@GetMapping("/delete")
	public String delete(@RequestParam("nounId") long id) {
		
		// delete the Noun
		nounService.deleteById(id);
		
		return "redirect:/nouns";
	}
}
