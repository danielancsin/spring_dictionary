package com.ancsin.spring.dictionary.entity;

import java.time.LocalDate;

public class User extends AbstractEntity {

//	@Id
//	private String userId;
	private String firstName;
	private String lastName;
	private LocalDate birthDate;
	private String email;

	public User() {
	}

	public User(String firstName, String lastName, LocalDate birthDate, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.email = email;
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
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", birthDate=" + birthDate + ", email="
				+ email + ", super.toString()=" + super.toString() + "]";
	}
	
}
