package com.ancsin.spring.dictionary.entity;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

public abstract class WordEntity extends AbstractEntity {

	@NotNull
	private String word;

	@NotNull
	@OneToOne
	@JoinColumn(name = "language_code_id")
	private LanguageCode languageCode;
	
	@Column(name = "is_approved")
	private boolean isApproved;
	
	//Level of Knowledge. E.g.: A1, B2, C1...
//	private String level;
	// NotesEntity, contains:
	//		Text - notes 
	//		boolean isPublic - whether or not it is public

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

	@Override
	public String toString() {
		return "WordEntity [word=" + word + ", languageCode=" + languageCode + ", isApproved=" + isApproved
				+ ", super.toString()=" + super.toString() + "]";
	}
	
}
