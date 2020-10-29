package com.ancsin.spring.dictionary.service.interfaces;

import java.util.List;

import com.ancsin.spring.dictionary.entity.LanguageCode;

public interface LanguageCodeService extends AbstractService<LanguageCode> {

	List<LanguageCode> searchBy(String word);
	
}
