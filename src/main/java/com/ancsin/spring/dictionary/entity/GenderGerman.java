package com.ancsin.spring.dictionary.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class GenderGerman extends AuditEntity {

	@Enumerated(EnumType.STRING)
	private EnumGenderGerman gender;

	public GenderGerman() {
	}

	public GenderGerman(EnumGenderGerman gender) {
		super();
		this.gender = gender;
	}

	public EnumGenderGerman getGender() {
		return gender;
	}

	public void setGender(EnumGenderGerman gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "GenderGerman [gender=" + gender + ", super.toString()=" + super.toString() + "]";
	}
	
}
