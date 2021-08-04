package com.codingdojo.objectmastertwo;

public class ClassTest {

	public static void main(String[] args) {

		Samurai auron = new Samurai("Auron");
		Wizard gandalf = new Wizard("Gandalf");
		Ninja naruto = new Ninja("Naruto");
		
		System.out.println(auron.getHealth());
		System.out.println(auron.deathBlow(naruto));
		System.out.println(auron.getHealth());
		System.out.println(naruto.getHealth());
		System.out.println(Samurai.howMany());
		System.out.println(auron.meditate());
		System.out.println(auron.getHealth());
		
		System.out.println(naruto.steal(auron));
		System.out.println(auron.getHealth());
		System.out.println(naruto.puffOfDarkness());
		System.out.println(naruto.getHealth());
		
		System.out.println(gandalf.heal(naruto));
		System.out.println(naruto.getHealth());
		System.out.println(gandalf.fireball(auron));
		System.out.println(auron.getHealth());
		
	}

}
