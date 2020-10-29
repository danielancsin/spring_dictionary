package com.ancsin.spring.dictionary.entity.abstracts;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.ancsin.spring.dictionary.entity.AbstractMeaning;
import com.ancsin.spring.dictionary.entity.LanguageCode;

@MappedSuperclass
public abstract class WordEntity<T extends AbstractMeaning> extends AuditEntity {

	@NotNull
	private String word;

//	@NotNull
	@OneToOne
	@JoinColumn(name = "language_code_id")
	private LanguageCode languageCode;
	
	@Column(name = "is_approved", columnDefinition = "boolean default false")
	private boolean isApproved;

	// TODO : meanings should be declared here, not in child classes
//	@ManyToMany(fetch = FetchType.LAZY,
//			cascade = {CascadeType.MERGE, CascadeType.REMOVE, CascadeType.PERSIST, CascadeType.REFRESH})
//	@JoinTable( name = "noun_meaning",
//	joinColumns = @JoinColumn(name = "noun_id"),
//	inverseJoinColumns = @JoinColumn(name = "meaning_id")
//			)
//	private List<AbstractMeaning> meanings;
	
	@ManyToMany
	@JoinColumn(name = "meaning_id")
	private List<T> meanings;

	public WordEntity() {
		super();
	}

	public WordEntity(String word, LanguageCode languageCode, boolean isApproved) {
		super();
		this.word = word;
		this.languageCode = languageCode;
		this.isApproved = isApproved;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public LanguageCode getLanguageCode() {
		return languageCode;
	}

	public void setLanguageCode(LanguageCode languageCode) {
		this.languageCode = languageCode;
	}

	public boolean isApproved() {
		return isApproved;
	}

	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}
	
	public List<T> getMeanings() {
		return meanings;
	}

	public void setMeanings(List<T> meaning) {
		this.meanings = meaning;
	}
	
	public void addMeanings(T meaning) {
		
		if (meanings == null)
			meanings = new ArrayList<>();
		
		meanings.add(meaning);
	}

	@Override
	public String toString() {
		return "WordEntity [word=" + word + ", languageCode=" + languageCode + ", isApproved=" + isApproved
				+ ", meanings=" + meanings + ", toString()=" + super.toString() + "]";
	}
	
}
