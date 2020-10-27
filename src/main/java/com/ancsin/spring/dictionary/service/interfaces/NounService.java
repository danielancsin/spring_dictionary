package com.ancsin.spring.dictionary.service.interfaces;

import java.util.List;

import com.ancsin.spring.dictionary.entity.Noun;

public interface NounService extends AbstractService<Noun> {

	List<Noun> findAllPaginated(int page, int size);
	
}
