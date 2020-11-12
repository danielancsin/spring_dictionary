package com.ancsin.spring.dictionary.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.ancsin.spring.dictionary.entity.abstracts.WordEntity;

@Entity
@Table(name = "verb")
public class Verb extends WordEntity<VerbMeaning> {

	
	private boolean isStrongVerb;
	
	// Präsens
	private String present;
	
	// Präteritum
	private String pastSimple;
	
	// Perfekt
	private String pastPerfect;
	
	// Plusquamperfekt
	private String pastPlus;
	
	// Futur I
	private String futureI;
	
	// Futur II
	private String futureII;
	
	// TODO : Konjuktiv I, II, usw....
	
}
