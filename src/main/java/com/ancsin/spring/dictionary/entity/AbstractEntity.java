package com.ancsin.spring.dictionary.entity;

import org.springframework.data.annotation.Id;

public abstract class AbstractEntity {

	@Id
	private Long id;

	public AbstractEntity() {
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "AbstractEntity [id=" + id + "]";
	}

}
