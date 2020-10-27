package com.ancsin.spring.dictionary.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.ancsin.spring.dictionary.entity.abstracts.WordEntity;

@Entity
@Table(	name = "noun", indexes = @Index(name = "ix_word", columnList = "word")
		/*,uniqueConstraints = @UniqueConstraint(columnNames = {"username", "email"})*/)
public class Noun extends WordEntity {

	@ManyToMany(fetch = FetchType.LAZY,
			cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable( name = "noun_gender",
			joinColumns = @JoinColumn(name = "noun_id"),
			inverseJoinColumns = @JoinColumn(name = "gender_id")
			)
	private List<EnumGenderGerman> genders;
	
	private String plural;
	
	@ManyToMany(fetch = FetchType.LAZY,
			cascade = {CascadeType.MERGE, CascadeType.REMOVE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable( name = "noun_meaning",
	joinColumns = @JoinColumn(name = "noun_id"),
	inverseJoinColumns = @JoinColumn(name = "meaning_id")
			)
	private List<Meaning> meanings;

	public Noun() {
		super();
	}

	public Noun(String plural) {
		super();
		this.plural = plural;
	}

	public List<EnumGenderGerman> getGenders() {
		return genders;
	}

	public void setGenders(List<EnumGenderGerman> genders) {
		this.genders = genders;
	}
	
	public void addGender(EnumGenderGerman gender) {
		
		if (genders == null)
			genders = new ArrayList<>();
		
		genders.add(gender);
	}

	public String getPlural() {
		return plural;
	}

	public void setPlural(String plural) {
		this.plural = plural;
	}
	
	public List<Meaning> getMeanings() {
		return meanings;
	}

	public void setMeanings(List<Meaning> meaning) {
		this.meanings = meaning;
	}
	
	public void addMeanings(Meaning meaning) {
		
		if (meanings == null)
			meanings = new ArrayList<>();
		
		meanings.add(meaning);
	}

	@Override
	public String toString() {
		return "Noun [genders=" + genders + ", plural=" + plural + ", meanings=" + meanings + ", toString()="
				+ super.toString() + "]";
	}

}
