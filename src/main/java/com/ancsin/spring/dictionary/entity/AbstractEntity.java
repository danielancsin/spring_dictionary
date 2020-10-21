package com.ancsin.spring.dictionary.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "datetime_created")
	private LocalDateTime dateCreated = LocalDateTime.now();
	@Column(name = "datetime_modified")
	private LocalDateTime dateModified;

	public AbstractEntity() {
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}

	public LocalDateTime getDateModified() {
		return dateModified;
	}

	public void setDateModified(LocalDateTime dateModified) {
		this.dateModified = dateModified;
	}

	@Override
	public String toString() {
		return "AbstractEntity [id=" + id + ", dateCreated=" + dateCreated + ", dateModified=" + dateModified + "]";
	}

}
