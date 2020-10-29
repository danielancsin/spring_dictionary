package com.ancsin.spring.dictionary.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ancsin.spring.dictionary.dao.LanguageCodeRepository;
import com.ancsin.spring.dictionary.entity.LanguageCode;
import com.ancsin.spring.dictionary.service.interfaces.LanguageCodeService;

@Service
public class LanguageCodeServiceImpl implements LanguageCodeService {

	@Autowired
	private LanguageCodeRepository languageCodeRepository;
	
	// TODO : user settings based pagination
	@Override
	public List<LanguageCode> findAll() {
		return languageCodeRepository.findAll();
	}

	@Override
	public LanguageCode findById(long id) {
		Optional<LanguageCode> result = languageCodeRepository.findById(id);
		
		LanguageCode code = null;
		
		if (result.isPresent()) {
			code = result.get();
		}
		else {
			// we didn't find the user
			throw new RuntimeException("Did not find language code by id - " + id);
		}
		
		return code;
	}

	@Override
	public LanguageCode save(LanguageCode user) {
		return languageCodeRepository.save(user);
	}

	@Override
	public void deleteById(long id) {
		languageCodeRepository.deleteById(id);
	}

	@Override
	public List<LanguageCode> searchBy(String word) {
		
		List<LanguageCode> results = null;
		
		if (word != null && (word.trim().length() > 0)) {
			results = languageCodeRepository.findByNameEnglishContainsAllIgnoreCase(word);
		}
		else {
			results = findAll();
		}
		
		return results;
	}


}
