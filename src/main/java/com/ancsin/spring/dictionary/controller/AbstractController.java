package com.ancsin.spring.dictionary.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ancsin.spring.dictionary.entity.abstracts.AbstractEntity;
import com.ancsin.spring.dictionary.service.interfaces.AbstractService;

public abstract class AbstractController<T extends AbstractEntity> {
	
	// store the type of the generic class
	private Class<T> type;
	
	// store the class name of the generic class
	protected String className;
			
	@Autowired
	private AbstractService<T> abstractService;
	
	// TODO : make it more flexible (individually set every mapping and entity name
	public AbstractController(AbstractService<T> abstractService, Class<T> type) {
		this(abstractService, type, type.getSimpleName().toLowerCase());
	}
	
	public AbstractController(AbstractService<T> abstractService, Class<T> type, String mappingAndEntitiesName) {
		this.abstractService = abstractService;
		this.type = type;
		this.className = mappingAndEntitiesName;
	}
	
	@GetMapping({"","/"})
	public String list(Model model) {
		
		List<T> entities = abstractService.findAll();
		
		// add to the spring model
		model.addAttribute(className+"s", entities);
		
		return "/" + className + "s";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		
		T entity;
		try {
			entity = (T) type.getDeclaredConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | 
				InvocationTargetException | NoSuchMethodException | SecurityException e) {
			// TODO : log the error, warn the user
			e.printStackTrace();
			return "/" + className + "s";
		}
		
		model.addAttribute(className, entity);
		
		return "/" + className + "-form";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("id") long id, Model model) {
		
		// get the Entity from the service
		T entity = abstractService.findById(id);
		
		// set Entity as a model attribute to pre-populate the form
		model.addAttribute(className, entity);
		
		// send over to the form
		return "/" + className + "-form";
	}
	
	
	@PostMapping("/save")
	public String save(@ModelAttribute T entity) {
		
		// save the Entity
		abstractService.save(entity);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/" + className + "s";
	}
	
	
	@GetMapping("/delete")
	public String delete(@RequestParam long id) {
		
		// delete the Entity
		abstractService.deleteById(id);
		
		return "redirect:/" + className + "s";
	}
	
	@GetMapping("/search")
	public String search(@RequestParam("name") String name, Model model) {
		
		List<T> entities = abstractService.searchBy(name);
		
		// add to the spring model
		model.addAttribute(className + "s", entities);
		
		return "/" + className + "s";
	}
	
}
