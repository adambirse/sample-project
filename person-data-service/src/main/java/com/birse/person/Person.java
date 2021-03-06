package com.birse.person;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
public class Person implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotNull
	@Size(min = 1, max = 20)
	private String firstName;

	@NotNull
	@Size(min = 1, max = 50)
	private String lastName;

	 public Person() {}


	 public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastname) {
		this.lastName = lastname;
	}

	public Long getId() {return this.id;}
	@Override
	public String toString() {
		return "Person [id= "+id +", firstName=" + this.firstName + ", lastName=" + this.lastName
				+ "]";
	}
}