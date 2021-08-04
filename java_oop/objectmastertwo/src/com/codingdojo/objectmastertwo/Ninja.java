package com.codingdojo.objectmastertwo;

import com.codingdojo.objectmastertwo.Human;

public class Ninja extends Human{

	public Ninja(String name) {
		super(name);
		super.setStealth(10);
	}

	public String steal(Human human) {
		human.setHealth(human.getHealth()-super.getStealth());
		return "You attacked " + human.getName()  + ". Their new health is: " + human.getHealth();
	}
	
	public String puffOfDarkness() {
		super.setHealth(getHealth()-10);
		return super.getName() + " flees from the battle in a puff of smoke. Health haas decreased and is now: " + super.getHealth();
	}

//	The Ninja class should have a default stealth of 10; a method, steal, that takes health from another 
//	human by their stealth level, and a way to run away that decreases their health by 10.
}
