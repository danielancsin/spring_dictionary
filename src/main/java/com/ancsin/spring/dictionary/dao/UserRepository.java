package com.ancsin.spring.dictionary.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ancsin.spring.dictionary.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	// add a method to sort by last name
		public List<User> findAllByOrderByLastNameAsc();
		
		// search by name
		public List<User> findByFirstNameContainsOrLastNameContainsAllIgnoreCase(String name, String lName);
	
}
