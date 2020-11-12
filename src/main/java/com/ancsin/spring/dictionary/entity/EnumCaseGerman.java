package com.ancsin.spring.dictionary.entity;

import com.ancsin.spring.dictionary.converter.AbstractEnumConverter;

public enum EnumCaseGerman implements PersistableEnum<String> {
	
	NOM("Nominative"),
	ACC("Accusative"),
	DAT("Dative"),
	GEN("Genitive");

	private final String value;

	EnumCaseGerman(String value) {
		this.value = value;
	}

	@Override
	public String getValue() {
		return value;
	}
	
	public static class Converter extends AbstractEnumConverter<EnumCaseGerman, String> {
        public Converter() {
            super(EnumCaseGerman.class);
        }
    }
	
}