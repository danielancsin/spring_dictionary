package com.ancsin.spring.dictionary.config;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ancsin.spring.dictionary.dao.LanguageCodeRepository;
import com.ancsin.spring.dictionary.entity.LanguageCode;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Component
public class EntityInitializer {

	// TODO : make an entity initializer, which goes through the
	// com.ancsin.spring.dictionary.entity package, and
	// - checks whether given table is in the database
	// - if not it creates it
	
	@Autowired
	LanguageCodeRepository languageCodeRepository;
	
	public EntityInitializer() {
	}

	// Why not to use Locale.getISOCountries() ?
	// 		Doesn't contain all the languages (e.g.: Swiss German)
	//		Not as maintainable - JDK update needed to insert any new language
	
	// TODO : find a better way to insert them and/or check whether given language is already inserted
	public void initLanguageCodes() {
//		long count = 0;
//		for (Locale locale : Locale.getAvailableLocales() ) {
//			System.out.println(
//					locale.getISO3Language()
//					);
//			count++;
//		}
//				
//		Locale.getISOCountries()
//		
//		Set<String> languages = Arrays.stream(Locale.getISOLanguages())
//	            .map(Locale::new)
//	            .map(Locale::getDisplayLanguage)
//	            .collect(Collectors.toCollection(TreeSet::new));
//		
//		System.out.println("################## " + count + " ##################");
//		
		long count = languageCodeRepository.count();
		
		if(count != 0)
			return;
		
		try {
			ObjectMapper mapper = new ObjectMapper()
					.registerModule(new JavaTimeModule());//LocalDateTime
			
			List<LanguageCode> codes = mapper.readValue(
					new File("data/language-codes-full_json.json"), 
					new TypeReference<List<LanguageCode>>(){});
			
//			codes.stream().forEach( c -> System.out.println(c.toString()) );
			
			languageCodeRepository.saveAll(codes);
			
		}
		catch (Exception e) {
			throw new RuntimeException("Unable to initialize LanguageCodes - " + e);
		}
	}
	
}
