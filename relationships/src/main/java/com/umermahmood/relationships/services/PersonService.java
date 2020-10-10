package com.umermahmood.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.umermahmood.relationships.models.Person;
import com.umermahmood.relationships.repositories.PersonRepository;

@Service // Sets class as service
public class PersonService {
	// <----- Attributes ----->
	// Dependency injection
	private final PersonRepository pRepo;
	
	// <----- Constructors ----->
	public PersonService(PersonRepository pRepo) {
		this.pRepo = pRepo;
	}
	
	// <----- Methods ----->
	// SELECT * FROM persons
	public List<Person> allPersons() {
		return pRepo.findAll();
	}
	
	// ADD
	public Person createPerson(Person p) {
		return pRepo.save(p);
	}
	
	// SELECT * FROM persons WHERE id =
	public Person findPerson(Long id) {
		// Optional allows the object to not exist
		Optional<Person> optionalP = pRepo.findById(id);
		if(optionalP.isPresent()) {
			return optionalP.get();
		} else {
			return null;
		}
	}
}
