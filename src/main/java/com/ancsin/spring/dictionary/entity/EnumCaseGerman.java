package com.ancsin.spring.dictionary.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

// Lazy init
@Entity
public enum EnumCaseGerman {
	
	NOM(1,"Nominative"),
	ACC(2,"Accusative"),
	DAT(3,"Dative"),
	GEN(4,"Genitive");

	@Id
	private final long id;
	@Column
	private final String name;
	
	private EnumCaseGerman(long id, String name) {
		this.id = id;
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
}