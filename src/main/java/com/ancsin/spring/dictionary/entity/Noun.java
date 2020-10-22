package com.ancsin.spring.dictionary.entity;

import javax.persistence.ManyToMany;

public class Noun extends WordEntity {

	@ManyToMany(mappedBy = "gender_id")
	private EnumGenderGerman gender;

	private String prefix;
	private String suffix;
}
