package com.ancsin.spring.dictionary.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.ancsin.spring.dictionary.entity.abstracts.WordEntity;

//@Entity
//@Table(	schema = "german",
//		name = "noun",
//		uniqueConstraints = @UniqueConstraint(columnNames = {"username", "email"}))

@Entity
@Table(	name = "noun"/*,
		uniqueConstraints = @UniqueConstraint(columnNames = {"username", "email"})*/)
public class Noun extends WordEntity {

//	@ManyToMany(mappedBy = "gender_id")
//	private List<EnumGenderGerman> genders;
	
	@ManyToMany(fetch = FetchType.LAZY,
			cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable( name = "noun_gender",
			joinColumns = @JoinColumn(name = "noun_id"),
			inverseJoinColumns = @JoinColumn(name = "gender_id")
			)
	private List<EnumGenderGerman> genders;
	
	private String plural;
	
//	@ManyToMany(mappedBy = "meaning_id")
//	private List<Meaning> meaning;

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

	@Override
	public String toString() {
		return "Noun [genders=" + genders.toString() + ", plural=" + plural + ", super.toString()=" + super.toString() + "]";
	}

//	public List<Meaning> getMeaning() {
//		return meaning;
//	}
//
//	public void setMeaning(List<Meaning> meaning) {
//		this.meaning = meaning;
//	}
//
//	@Override
//	public String toString() {
//		return "Noun [gender=" + gender + ", plural=" + plural + ", meaning=" + meaning + ", toString()="
//				+ super.toString() + "]";
//	}
	
}
