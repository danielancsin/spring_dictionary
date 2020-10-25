package com.ancsin.spring.dictionary.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.ancsin.spring.dictionary.entity.abstracts.AuditEntity;

@Entity
@Table(	/*schema = "german",*/
		name = "meaning")
public class Meaning extends AuditEntity {
	
	private String note;
	@Column(name = "is_public")
	private boolean isPublic;
	@Column(name = "is_approved")
	private boolean isApproved;
	
	public Meaning() {
		super();
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public boolean isPublic() {
		return isPublic;
	}

	public void setPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}

	public boolean isApproved() {
		return isApproved;
	}

	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}

	@Override
	public String toString() {
		return "Meaning [note=" + note + ", isPublic=" + isPublic + ", isApproved=" + isApproved + ", super.toString()="
				+ super.toString() + "]";
	}
	
}
