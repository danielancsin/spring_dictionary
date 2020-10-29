package com.ancsin.spring.dictionary.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ancsin.spring.dictionary.dao.UserRepository;
import com.ancsin.spring.dictionary.entity.User;
import com.ancsin.spring.dictionary.service.interfaces.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	// TODO : user settings based pagination
	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User findById(long id) {
		Optional<User> result = userRepository.findById(id);
		
		User user = null;
		
		if (result.isPresent()) {
			user = result.get();
		}
		else {
			// we didn't find the user
			throw new RuntimeException("Did not find employee by id - " + id);
		}
		
		return user;
	}

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public void deleteById(long id) {
		userRepository.deleteById(id);
	}

	@Override
	public List<User> searchBy(String name) {
		
		List<User> results = null;
		
		if (name != null && (name.trim().length() > 0)) {
			results = userRepository.findByFirstNameContainsOrLastNameContainsAllIgnoreCase(name, name);
		}
		else {
			results = findAll();
		}
		
		return results;
	}

}
