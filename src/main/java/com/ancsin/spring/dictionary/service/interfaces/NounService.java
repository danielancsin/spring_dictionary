package com.ancsin.spring.dictionary.service.interfaces;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ancsin.spring.dictionary.entity.Noun;

public interface NounService extends AbstractService<Noun> {

	Page<Noun> findAllPaginated(Pageable pageable);

	Page<Noun> findByWordContainsAllIgnoreCase(String word, Pageable pageable);

	List<Noun> searchBy(String word);
	
}
