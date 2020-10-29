package com.ancsin.spring.dictionary.entity;

import com.ancsin.spring.dictionary.converter.AbstractEnumConverter;

public enum EnumGenderGerman implements PersistableEnum<String> {
	
	DER("der"),
	DIE("die"),
	DAS("das");

	private final String value;
	
	EnumGenderGerman(String value) {
		this.value = value;
	}

	@Override
	public String getValue() {
		return value;
	}
	
	public static class Converter extends AbstractEnumConverter<EnumGenderGerman, String> {
        public Converter() {
            super(EnumGenderGerman.class);
        }
    }

}
