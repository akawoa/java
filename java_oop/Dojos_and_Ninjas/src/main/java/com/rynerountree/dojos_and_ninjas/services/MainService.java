package com.rynerountree.dojos_and_ninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rynerountree.dojos_and_ninjas.models.Ninja;
import com.rynerountree.dojos_and_ninjas.models.Dojo;
import com.rynerountree.dojos_and_ninjas.repositories.NinjaRepository;
import com.rynerountree.dojos_and_ninjas.repositories.DojoRepository;

@Service
public class MainService {
	@Autowired
	private DojoRepository dojoRepo;
	
	@Autowired
	private NinjaRepository ninjaRepo;
	
	// --------------------  CRUD FOR USERS ------------------//
	public List<Dojo> allDojos(){
		return dojoRepo.findAll();
	}
	public Dojo saveDojo(Dojo d) {
		return dojoRepo.save(d);
	}
	// retrieves a dojo
	public Dojo findDojo(Long id) {
        Optional<Dojo> optionalDojo = dojoRepo.findById(id);
        if(optionalDojo.isPresent()) {
            return optionalDojo.get();
        } else {
            return null;
        }
	}
	
	// --------------------  CRUD FOR SALES ------------------//
	public Ninja saveNinja(Ninja n) {
		return ninjaRepo.save(n);
	}
	
	
}
