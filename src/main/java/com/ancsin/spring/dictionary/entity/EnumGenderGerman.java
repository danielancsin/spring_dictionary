package com.ancsin.spring.dictionary.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

// Lazy init
@Entity
public enum EnumGenderGerman {
	
	DER(1,"der"),
	DIE(2,"die"),
	DAS(3,"das");

	@Id
	private final long id;
	@Column
	private final String name;
	
	private EnumGenderGerman(long id, String name) {
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