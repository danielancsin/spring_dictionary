package com.ancsin.spring.dictionary.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class CodeEntity extends AbstractEntity {

	@Column(name = "name")
	private String name;
	@Column(name = "code")
	private String code;

	public CodeEntity() {
		super();
	}

	public CodeEntity(String name, String code) {
		super();
		this.name = name;
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "CodeEntity [name=" + name + ", code=" + code + ", super.toString()=" + super.toString() + "]";
	}
	
}
