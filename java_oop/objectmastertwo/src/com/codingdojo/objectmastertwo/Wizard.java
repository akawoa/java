package com.codingdojo.objectmastertwo;

import com.codingdojo.objectmastertwo.Human;

public class Wizard extends Human {

	public Wizard(String name) {
		super(name);
		super.setHealth(50);
		super.setIntelligence(8);
	}
//	The Wizard class should have a default health of 50 and intelligence of 8; a method called heal that heals whomever it was cast on for an amount equal to the wizard's intelligence; and a method called fireball that decreases the health of whichever object it attacked by 3 * the wizard's intelligence.
	
	
	public String heal(Human human) {
		human.setHealth(getHealth()+super.getIntelligence());
		return human.getName() + " is healed for " + super.getIntelligence() + "points. Their new health is: " + human.getHealth();
	}
	
	public String fireball(Human human) {
		human.setHealth(getHealth()-(super.getIntelligence()*3));
		return human.getName() + " is hit by a fireball for " + (super.getIntelligence()*3) + " damage, their new health is: " + human.getHealth();
	}
	
}
