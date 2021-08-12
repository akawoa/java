package com.rynerountree.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rynerountree.languages.models.Language;
import com.rynerountree.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	private final LanguageRepository languageRepository;

	public LanguageService(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}

	// returns all the languages
	public List<Language> allLanguages() {
		return languageRepository.findAll();
	}

	// creates a language
	public Language createLanguage(Language l) {
		return languageRepository.save(l);
	}

	// retrieves a language
	public Language findLanguage(Long id) {
        Optional<Language> optionalLanguage = languageRepository.findById(id);
        if(optionalLanguage.isPresent()) {
            return optionalLanguage.get();
        } else {
            return null;
        }
	}
	
	// deletes a language
	public void deleteLanguage(Long id) {
		languageRepository.deleteById(id);
	}
  
    // edits a language
    public Language updateLanguage(Language l) {
    	return languageRepository.save(l);
    }
    
    public Optional<Language> updateLanguage(Long id, String name, String creator, String version) {
    	Optional <Language> temp = languageRepository.findById(id);
    	   		if (languageRepository.findById(id).isPresent()) {
    			Language existingLanguage = languageRepository.findById(id).get();
    			
    			existingLanguage.setName(name);
    			existingLanguage.setCreator(creator);
    			existingLanguage.setVersion(version);
        		
        		Language updatedLanguage = languageRepository.save(existingLanguage);
        		
        		return languageRepository.findById(updatedLanguage.getId());
    		
    	}
    	return null;        
    }
}
