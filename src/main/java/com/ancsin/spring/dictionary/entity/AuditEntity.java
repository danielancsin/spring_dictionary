package com.ancsin.spring.dictionary.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;

public abstract class AuditEntity extends AbstractEntity {


	@Column(name = "datetime_created")
	private LocalDateTime dateCreated = LocalDateTime.now();
	@Column(name = "datetime_modified")
	private LocalDateTime dateModified;
	@Column(name = "user_created_by")
	private User userCreatedBy;
	@Column(name = "user_modified_by")
	private User userModifiedBy;
	
	public AuditEntity() {
	}
	
	public AuditEntity(LocalDateTime dateCreated, LocalDateTime dateModified, User userCreatedBy, User userModifiedBy) {
		super();
		this.dateCreated = dateCreated;
		this.dateModified = dateModified;
		this.userCreatedBy = userCreatedBy;
		this.userModifiedBy = userModifiedBy;
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
		return "AuditEntity [dateCreated=" + dateCreated + ", dateModified=" + dateModified + ", userCreatedBy="
				+ userCreatedBy + ", userModifiedBy=" + userModifiedBy + ", toString()=" + super.toString() + "]";
	}

}
