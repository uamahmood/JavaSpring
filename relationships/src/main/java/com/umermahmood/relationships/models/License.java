package com.umermahmood.relationships.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity // sets class as DB object
@Table(name="licenses") // DB table object belongs
public class License {
	// <----- Attributes ----->
	@Id // sets table id for SQL
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increments
	private Long id;
	private String number;
	@DateTimeFormat(pattern = "yyyy-MM-dd")  // Proper formatting from web form
	private Date expirationDate;
	private String state;
	@Column(updatable=false) // attribute is immutable after creation
	private Date createdAt;
	private Date updatedAt;
	
	// Annotation for relationship -- model object attribute IS THE RELATED OBJECT!
	// This is the Syntax for the secondary object in the relationship
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="person_id") // Maps foreign keys
	private Person person;
	
	// <----- Constructors ----->
	public License() {
		
	}

	// <----- Getters/Setters ----->
	// id
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	// number
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	// expirationDate
	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	// state
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
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

	// Person object
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
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