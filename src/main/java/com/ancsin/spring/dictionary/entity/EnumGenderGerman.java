package com.ancsin.spring.dictionary.entity;

// Lazy init
public enum EnumGenderGerman {
	
	DER(1,"der"),
	DIE(2,"die"),
	DAS(3,"das");
	// TODO : is "DIE" plural needed???

	private final long id;
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