package com.ancsin.spring.dictionary.entity;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

// ISO 639-2
// https://datahub.io/core/language-codes
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class LanguageCode extends AbstractEntity 
/*extends CodeEntity*/ {

	@NotNull
	@JsonProperty("English")
	private String nameEnglish; 
	@JsonProperty("French")
	private String nameFrench; 
	@JsonProperty("alpha2")
	private String alpha2;
	@JsonProperty("alpha3-b")
	private String alpha3_b;
	@JsonProperty("alpha3-t")
	private String alpha3_t;
	
	public LanguageCode() {
	}

	public String getNameEnglish() {
		return nameEnglish;
	}

	public void setNameEnglish(String nameEnglish) {
		this.nameEnglish = nameEnglish;
	}

	public String getNameFrench() {
		return nameFrench;
	}

	public void setNameFrench(String nameFrench) {
		this.nameFrench = nameFrench;
	}

	public String getAlpha2() {
		return alpha2;
	}

	public void setAlpha2(String alpha2) {
		this.alpha2 = alpha2;
	}

	public String getAlpha3_b() {
		return alpha3_b;
	}

	public void setAlpha3_b(String alpha3_b) {
		this.alpha3_b = alpha3_b;
	}

	public String getAlpha3_t() {
		return alpha3_t;
	}

	public void setAlpha3_t(String alpha3_t) {
		this.alpha3_t = alpha3_t;
	}

	@Override
	public String toString() {
		return "LanguageCode [nameEnglish=" + nameEnglish + ", nameFrench=" + nameFrench + ", alpha2=" + alpha2
				+ ", alpha3_b=" + alpha3_b + ", alpha3_t=" + alpha3_t + ", toString()=" + super.toString() + "]";
	}
	
}
