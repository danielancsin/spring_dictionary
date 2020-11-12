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
@Table(name = "case_german")
public class CaseGerman extends AuditEntity {

	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	@Convert(attributeName = "value", converter = EnumCaseGerman.Converter.class)
	private EnumCaseGerman caseGerman;
	
	@ManyToMany(fetch = FetchType.LAZY,
			cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable( name = "noun_case",
			joinColumns = @JoinColumn(name = "case_id"),
			inverseJoinColumns = @JoinColumn(name = "noun_id")
			)
	private List<Noun> nouns;

	public CaseGerman() {
	}

	public CaseGerman(EnumCaseGerman caseGerman) {
		super();
		this.caseGerman = caseGerman;
	}

	public EnumCaseGerman getCaseGerman() {
		return caseGerman;
	}

	public void setCaseGerman(EnumCaseGerman caseGerman) {
		this.caseGerman = caseGerman;
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
		return "CaseGerman [caseGerman=" + caseGerman + ", nouns=" + nouns + ", super.toString()=" + super.toString() + "]";
	}
	
}
