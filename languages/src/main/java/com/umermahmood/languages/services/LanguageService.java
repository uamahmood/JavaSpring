package com.umermahmood.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.umermahmood.languages.models.Language;
import com.umermahmood.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	// <-- Attributes & Dependency injection -->
	private final LanguageRepository langRepo;
	
	// <-- Constructors -->
	public LanguageService(LanguageRepository langRepo) {
		this.langRepo = langRepo;
	}
	
	//<-- Methods -->
	public List<Language> allLanguages(){
		return langRepo.findAll();
	}
	
	public Language findLang(Long id) {
		Optional<Language> optionalLang = langRepo.findById(id);
		if(optionalLang.isPresent()) {
			return optionalLang.get();
		} else {
			return null;
		}
	}
	
	public Language createLang(Language lang) {
		return langRepo.save(lang);
	}
	
	public Language updateLang(Long id, String name, String creator, String version) {
		Optional<Language> optionalLang = langRepo.findById(id);
		if(optionalLang.isPresent()) {
			Language updateLang = optionalLang.get();
			// Update fields
			updateLang.setName(name);
			updateLang.setCreator(creator);
			updateLang.setVersion(version);
			
			return langRepo.save(updateLang);
		} else {
			return null;
		}
	}
	
	public void deleteLang(Long id) {
			langRepo.deleteById(id);
		
	}
}
