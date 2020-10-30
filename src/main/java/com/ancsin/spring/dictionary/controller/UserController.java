package com.ancsin.spring.dictionary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ancsin.spring.dictionary.entity.User;
import com.ancsin.spring.dictionary.service.interfaces.AbstractService;

@Controller
@RequestMapping("/users")
public class UserController extends AbstractController<User> {

	public UserController(AbstractService<User> userService) {
		super(userService, User.class);
	}
	
}
