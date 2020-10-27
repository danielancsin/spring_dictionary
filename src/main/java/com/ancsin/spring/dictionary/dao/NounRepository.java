package com.ancsin.spring.dictionary.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ancsin.spring.dictionary.entity.Noun;

public interface NounRepository extends JpaRepository<Noun, Long> {

	// TODO : add methods to queries
	public List<Noun> findByWordContainsAllIgnoreCase(String word);
	
	
}
