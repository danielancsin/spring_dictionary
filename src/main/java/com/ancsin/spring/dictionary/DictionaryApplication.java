package com.ancsin.spring.dictionary;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ancsin.spring.dictionary.config.EntityInitializer;

@SpringBootApplication
public class DictionaryApplication {

	public static void main(String[] args) {
		SpringApplication.run(DictionaryApplication.class, args);
	}

	@Autowired
	private EntityInitializer entityInitializer;
	
	@PostConstruct
	public void init() {
		entityInitializer.initLanguageCodes();
	}
}
