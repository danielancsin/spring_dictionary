package com.ancsin.spring.dictionary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ancsin.spring.dictionary.entity.LanguageCode;
import com.ancsin.spring.dictionary.service.interfaces.AbstractService;

@Controller
@RequestMapping("/langcodes")
public class LanguageCodeController extends AbstractController<LanguageCode> {

	public LanguageCodeController(AbstractService<LanguageCode> abstractService) {
		super(abstractService, LanguageCode.class);
	}

}
