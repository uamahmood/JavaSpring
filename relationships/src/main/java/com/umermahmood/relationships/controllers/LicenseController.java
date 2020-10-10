package com.umermahmood.relationships.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.umermahmood.relationships.models.License;
import com.umermahmood.relationships.models.Person;
import com.umermahmood.relationships.services.LicenseService;
import com.umermahmood.relationships.services.PersonService;

@Controller // Sets class as a controller
@RequestMapping("licenses")
public class LicenseController {
	// <----- Attributes ----->
		// Dependency injection
		private final LicenseService lService;
		private final PersonService pService;
		
		// <----- Constructors ----->
		public LicenseController(LicenseService lService, PersonService pService) {
			this.lService = lService;
			this.pService = pService;
		}
		
		// <----- Methods ----->
		// GET routes

		// GET route for new license form
		@RequestMapping(value="new", method=RequestMethod.GET)
		// @ModelAttribute binds a blank model to the form
		public String newLicense(@ModelAttribute("license") License license, Model model) {
			// Queries DB for all persons to bind to the view Model
			List<Person> persons = pService.allPersons();
			model.addAttribute("persons", persons);
			
			return "licenses/new.jsp";
		}
		
		// POST routes
		
		// POST route to ADD new license
		@RequestMapping(value="new", method=RequestMethod.POST)
		// The @Valid annotation checks to see if the submitted object passed validation
		// @BindingResult must come immediately after the @Valid annotation parameter. This tells the application to check for errors!
		public String addNewLicense(@Valid @ModelAttribute("license") License license, BindingResult result, Model model) {
			// Event handler for error checking
			if (result.hasErrors()) {
				return "licenses/new.jsp"; 
			} else {
				license.setNumber(String.format("%06d", lService.allLicenses().size()+1));
				lService.createLicense(license);
				Long path = license.getPerson().getId();
				return "redirect:/persons/" + path;
			}
		}
	}

