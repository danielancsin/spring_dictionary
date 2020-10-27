package com.ancsin.spring.dictionary.entity.abstracts;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AuditEntity extends AbstractEntity {


	@Column(name = "created_datetime")
	private LocalDateTime dateCreated = LocalDateTime.now();
	@Column(name = "modified_datetime")
	private LocalDateTime dateModified;
	@Column(name = "created_by")
	private String userCreatedBy;
	@Column(name = "modified_by")
	private String userModifiedBy;
	
	public AuditEntity() {
	}
	
	public AuditEntity(LocalDateTime dateCreated, LocalDateTime dateModified, String userCreatedBy, String userModifiedBy) {
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
	
	public String getUserCreatedBy() {
		return userCreatedBy;
	}

	public void setUserCreatedBy(String userCreatedBy) {
		this.userCreatedBy = userCreatedBy;
	}

	public String getUserModifiedBy() {
		return userModifiedBy;
	}

	public void setUserModifiedBy(String userModifiedBy) {
		this.userModifiedBy = userModifiedBy;
	}

	@Override
	public String toString() {
		return "AuditEntity [dateCreated=" + dateCreated + ", dateModified=" + dateModified + ", userCreatedBy="
				+ userCreatedBy + ", userModifiedBy=" + userModifiedBy + ", toString()=" + super.toString() + "]";
	}

}
