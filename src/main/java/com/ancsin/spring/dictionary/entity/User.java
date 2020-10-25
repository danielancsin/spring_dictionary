package com.ancsin.spring.dictionary.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import com.ancsin.spring.dictionary.entity.abstracts.AuditEntity;

@Entity
@Table(	name = "user",
		uniqueConstraints = @UniqueConstraint(columnNames = {"username", "email"}))
public class User extends AuditEntity {

//	@Id
//	private String userId;
	@NotNull
	@Column(name = "username")
	private String username;
	@NotNull
	@Column(name = "first_name")
	private String firstName;
	@NotNull
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "birth_date")
	private LocalDate birthDate;
	@NotNull
	@Column(name = "email")
	private String email;

	public User() {
	}

	public User(String username, String firstName, String lastName, LocalDate birthDate, String email) {
		super();
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", firstName=" + firstName + ", lastName=" + lastName + ", birthDate="
				+ birthDate + ", email=" + email + ", super.toString()=" + super.toString() + "]";
	}
	
}
