package com.ancsin.spring.dictionary.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ancsin.spring.dictionary.entity.User;
import com.ancsin.spring.dictionary.service.interfaces.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping({"","/"})
	public String listUsers(Model model) {
		
		// get Users from db
		List<User> users = userService.findAll();
		
		// add to the spring model
		model.addAttribute("users", users);
		
		return "/users";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		
		// create model attribute to bind form data
		User user = new User();
		
		model.addAttribute("user", user);
		
		return "/user-form";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("userId") long id, Model model) {
		
		// get the User from the service
		User user = userService.findById(id);
		
		// set User as a model attribute to pre-populate the form
		model.addAttribute("user", user);
		
		// send over to our form
		return "/user-form";			
	}
	
	
	@PostMapping("/save")
	public String saveUser(@ModelAttribute("user") User theUser) {
		
		// save the User
		userService.save(theUser);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/users";
	}
	
	
	@GetMapping("/delete")
	public String delete(@RequestParam("userId") long id) {
		
		// delete the User
		userService.deleteById(id);
		
		return "redirect:/users";
	}
	
	@GetMapping("/search")
	public String search(@RequestParam("userName") String name, Model model) {
		
		// delete the User
		List<User> users = userService.searchBy(name);
		
		// add to the spring model
		model.addAttribute("users", users);
		
		return "/users";
	}
}
