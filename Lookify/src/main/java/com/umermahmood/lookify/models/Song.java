package com.umermahmood.lookify.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "songs") // Set the table for the Entity object
public class Song {
	// Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Size(min = 5, message = " Length of title must be longer than 5 characters")
	private String title;
	@Size(min = 5, message = " Length of artist must be longer than 5 characters")
	private String artist;
	@Min(1) // rating must between 1-10
	@Max(10)
	private Integer rating;
	@Column(updatable = false) // immutable after creation
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;

	// Constructors
	public Song() {

	}

	public Song(String title, String artist, int rating) {
		this.title = title;
		this.artist = artist;
		this.rating = rating;
	}

	// Getters/Setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	// Methods
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();

	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}

}
