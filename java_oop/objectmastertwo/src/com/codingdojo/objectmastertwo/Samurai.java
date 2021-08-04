package com.codingdojo.objectmastertwo;

import com.codingdojo.objectmastertwo.Human;

public class Samurai extends Human{
	private static int numberOfSamurai = 0;
	public Samurai(String name) {
		super(name);
		super.setHealth(200);
		numberOfSamurai++;
	}
//	The Samurai class should have a default health of 200; a method called deathBlow that attacks an object and decreases its health to 0,
//	but also halves the Samurai's health; a method called meditate which heals the Samurai back to full health; and a method called howMany that returns the current number of Samurai.
	//Add the attack(Human) method that reduces the health of the attacked human by the strength of the current human.
	public String deathBlow(Human human) {
		human.setHealth(0);	
		super.setHealth(super.getHealth()/2);
		return "You attacked " + human.getName()  + ". Their new health is: " + human.getHealth();
	}
	
	public String meditate() {
		super.setHealth(200);
		return super.getName() + " takes a moment to reflect on their thoughts. Their new health is: " + super.getHealth();
	}
	
	static String howMany() {
		return "The current number of Samurai that exist is: " + numberOfSamurai;
	}
}
