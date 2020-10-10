package com.umermahmood.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.umermahmood.languages.models.Language;
import com.umermahmood.languages.services.LanguageService;

@Controller
public class LanguagesController {
	// <-- Attributes & Dependency injection -->
	private final LanguageService langService;
	
	// <-- Constructors -->
	public LanguagesController(LanguageService langService) {
		this.langService = langService;
	}
	
	// <-- Methods -->
	// GET route for languages
	@RequestMapping(value="languages", method=RequestMethod.GET)
	// Model used for instantiating and binding to our view model
	public String index(Model model, @ModelAttribute("language")Language language) {
		List<Language> languages = langService.allLanguages();
		model.addAttribute("languages", languages);
		return "languages/index.jsp";
	}
	
	@GetMapping("/other")
	public String test() {
		return "languages/otherIndex.jsp";
	}
	
	// Post route for creation
	@RequestMapping(value="languages", method=RequestMethod.POST)
	// @Valid checks for validation
	// @BindingResult after, checks for errors
	public String create(@Valid @ModelAttribute("language") Language language, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Language> languages = langService.allLanguages();
			model.addAttribute("languages", languages);
			return "/languages/index.jsp";
		}else {
			langService.createLang(language);
			return "redirect:/languages";
		}
	}
	
	// GET route for show id
	@RequestMapping(value="languages/{id}", method=RequestMethod.GET)
	// @Path for query and Model for binding view
	public String show(@PathVariable("id") Long id, Model model) {
		Language language = langService.findLang(id);
		model.addAttribute("language", language);
		return "/languages/show.jsp";
	}
	
	// GET route for edit id
	@RequestMapping(value="languages/{id}/edit", method=RequestMethod.GET)
	public String edit(@PathVariable("id") Long id, Model model) {
		Language language = langService.findLang(id);
		model.addAttribute("language", language);
		return "/languages/edit.jsp";
	}

	
	// PUT route for update by id
	@RequestMapping(value="languages/{id}", method=RequestMethod.PUT)
	public String update(@Valid @ModelAttribute("language") Language language,BindingResult result, @PathVariable("id") Long id,
			@RequestParam(value="name") String name, @RequestParam(value="creator") String creator, @RequestParam(value="version") String version){
		
		if (result.hasErrors()) {
			return "languages/edit.jsp";
		} else {
			langService.updateLang(id, name, creator, version);
			return "redirect:/languages";
		}
	}
	// DELETE Route by id
		@RequestMapping(value="/languages/{id}", method=RequestMethod.DELETE)
		public String destory(@PathVariable("id") Long id) {
			// Queries and deletes language from PathVariable
			langService.deleteLang(id);
			return "redirect:/languages";
		}
}
