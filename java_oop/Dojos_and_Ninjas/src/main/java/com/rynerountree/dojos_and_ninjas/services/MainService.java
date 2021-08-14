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
	
	// --------------------  CRUD FOR DOJOS ------------------//
	//finds all dojos
	public List<Dojo> allDojos(){
		return dojoRepo.findAll();
	}
	//creates a dojo
	public Dojo saveDojo(Dojo d) {
		return dojoRepo.save(d);
	}
	// retrieves a dojo by their id
	public Dojo findDojo(Long id) {
        Optional<Dojo> optionalDojo = dojoRepo.findById(id);
        if(optionalDojo.isPresent()) {
            return optionalDojo.get();
        } else {
            return null;
        }
	}
	//deletes a dojo by their id
	public void deleteDojo(Long dojo_id) {
		dojoRepo.deleteById(dojo_id);
	}
	
	// --------------------  CRUD FOR NINJAS ------------------//
	//saves a ninja
	public Ninja saveNinja(Ninja n) {
		return ninjaRepo.save(n);
	}
	//deletes a ninja
	public void deleteNinja(Long ninja_id) {
		ninjaRepo.deleteById(ninja_id);
	}
	
	
}
