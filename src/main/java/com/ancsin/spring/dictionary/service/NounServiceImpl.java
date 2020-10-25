package com.ancsin.spring.dictionary.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ancsin.spring.dictionary.dao.NounRepository;
import com.ancsin.spring.dictionary.entity.Noun;
import com.ancsin.spring.dictionary.service.interfaces.NounService;

@Service
public class NounServiceImpl implements NounService {

	@Autowired
	private NounRepository nounRepository;
	
	@Override
	public List<Noun> findAll() {
		return nounRepository.findAll();
	}

	@Override
	public Noun findById(long id) {
		
		Optional<Noun> result = nounRepository.findById(id);
		
		Noun noun = null;
		
		if (result.isPresent())
			noun = result.get();
		else
			throw new RuntimeException("Did not find noun by id - " + id);
		
		return noun;
	}

	@Override
	public void save(Noun t) {
		nounRepository.save(t);
	}

	@Override
	public void deleteById(long id) {
		nounRepository.deleteById(id);
	}

	@Override
	public List<Noun> searchBy(String name) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public List<Noun> searchBy(String word) {
//		
//		List<Noun> results = null;
//		
//		if(word != null && (word.trim().length() > 0) )
//			results = nounRepository.findByWordContainsAllIgnoreCase(word);
//		else
//			results = findAll();
//		
//		return results;
//	}

}
