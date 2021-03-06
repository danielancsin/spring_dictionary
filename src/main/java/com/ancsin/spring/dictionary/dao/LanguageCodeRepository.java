package com.ancsin.spring.dictionary.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ancsin.spring.dictionary.entity.LanguageCode;

public interface LanguageCodeRepository extends JpaRepository<LanguageCode, Long> {

	// TODO - queries
	public List<LanguageCode> findByNameEnglishContainsAllIgnoreCase(String word);
	
}
