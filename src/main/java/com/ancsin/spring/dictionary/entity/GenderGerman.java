package com.ancsin.spring.dictionary.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.ancsin.spring.dictionary.entity.abstracts.AuditEntity;

@Entity
@Table(name = "gender_german")
public class GenderGerman extends AuditEntity {

	@Enumerated(EnumType.STRING)
	@Column(length = 3)
	@Convert(attributeName = "name", converter = EnumGenderGerman.Converter.class)
	private EnumGenderGerman gender;

	@ManyToMany(fetch = FetchType.LAZY,
			cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable( name = "noun_gender",
			joinColumns = @JoinColumn(name = "gender_id"),
			inverseJoinColumns = @JoinColumn(name = "noun_id")
			)
	private List<Noun> nouns;
	
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

	public List<Noun> getNouns() {
		return nouns;
	}

	public void setNouns(List<Noun> nouns) {
		this.nouns = nouns;
	}

	public void addNoun(Noun noun) {
		
		if (nouns == null)
			nouns = new ArrayList<>();
		
		nouns.add(noun);
	}

	@Override
	public String toString() {
		return "GenderGerman [gender=" + gender + ", nouns=" + nouns + ", super.toString()=" + super.toString() + "]";
	}
	
}
