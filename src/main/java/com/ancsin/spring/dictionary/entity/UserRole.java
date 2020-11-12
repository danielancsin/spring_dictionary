package com.ancsin.spring.dictionary.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;

import com.ancsin.spring.dictionary.entity.abstracts.AuditEntity;

public class UserRole extends AuditEntity {

	private String name;
	
	@Column(name = "valid_from")
	private LocalDateTime validFrom;
	
	@Column(name = "valid_to")
	private LocalDateTime validTo;
	
	// TODO : validation...
}
