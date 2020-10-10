package com.umermahmood.relationships.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.umermahmood.relationships.models.Person;
import com.umermahmood.relationships.services.PersonService;

@Controller // Sets class as controller
@RequestMapping("persons")
public class PersonController {
	// <----- Attributes ----->
	// Dependency injection
	private final PersonService pService;
	
	// <----- Constructors ----->
	public PersonController(PersonService pService) {
		this.pService = pService;
	}
	
	// <----- Methods ----->
	// GET routes

	// GET route for new person form
	@RequestMapping(value="new", method=RequestMethod.GET)
	// @ModelAttribute binds a blank model to the form
	public String newPerson(@ModelAttribute("person") Person person) {
		return "persons/new.jsp";
	}
	
	// GET route for show person
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	// @PathVariable used to query DB, Model binds data to View
	public String showPerson(@PathVariable("id") Long id, Model model) {
		// Optional determines if data in in DB
		Person person = pService.findPerson(id);
		model.addAttribute("person", person);
		
		return "persons/show.jsp";
	}	
	
	// POST routes
	
	// POST route to ADD new person
	@RequestMapping(value="new", method=RequestMethod.POST)
	// The @Valid annotation checks to see if the submitted object passed validation
	// @BindingResult must come immediately after the @Valid annotation parameter. This tells the application to check for errors!
	public String addNewPerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		// Event handler for error checking
		if (result.hasErrors()) {
			return "persons/new.jsp"; 
		} else {
			pService.createPerson(person);
			return "redirect:/persons/new";
		}
	}
}