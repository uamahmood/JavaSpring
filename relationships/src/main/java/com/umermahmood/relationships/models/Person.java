package com.umermahmood.relationships.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity // sets class as DB object
@Table(name="persons") // DB table object belongs
public class Person {
	// <----- Attributes ----->
	@Id // sets table id for SQL
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increments
	private Long id;
	private String firstName;
	private String lastName;
	@Column(updatable=false) // attribute is immutable after creation
	private Date createdAt;
	private Date updatedAt;
	
	// Annotation for relationship -- model object attribute IS THE RELATED OBJECT!
	// This is the Syntax for the primary object in the relationship
	// mappedBy -- only used in the primary object. Maps License attribute in the Person class to the Person attribute in the License class
	// cascade -- ensure referential integrity is preserved among ALL actions that use EITHER object
	// fetch -- LAZY: fetches when needed, EAGER: fetched in all cases
	@OneToOne(mappedBy="person", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private License license;
	
	// <----- Constructors ----->
	public Person() {
		
	}

	// <----- Getters/Setters ----->
	// id
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	// firstName
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	// lastName
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	// createdAt
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	// updatedAt
	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	// License object
	public License getLicense() {
		return license;
	}

	public void setLicense(License license) {
		this.license = license;
	}
	// <-- Methods -->
		@PrePersist
		protected void onCreate() {
			this.createdAt = new Date();
		}
		
		@PreUpdate
		protected void onUpdate() {
			this.updatedAt = new Date();
		}
}
