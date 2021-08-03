package com.codingdojo.objectmasterone;

public class Human {
		private int strength;
		private int stealth;
		private int intelligence;
		private int health;
		private String name;
//Create a Human class
//Add the strength, stealth, and intelligence attributes with a default of 3
//Add the health attribute with a default of 100
//Add the attack(Human) method that reduces the health of the attacked human by the strength of the current human.
		public Human (String name) {
			this.strength = 3;
			this.stealth = 3;
			this.intelligence = 3;
			this.health = 100;
			this.name = name;
		}

		
		public int getStrength() {
			return strength;
		}


		public void setStrength(int strength) {
			this.strength = strength;
		}


		public int getStealth() {
			return stealth;
		}


		public void setStealth(int stealth) {
			this.stealth = stealth;
		}


		public int getIntelligence() {
			return intelligence;
		}


		public void setIntelligence(int intelligence) {
			this.intelligence = intelligence;
		}


		public int getHealth() {
			return health;
		}


		public void setHealth(int health) {
			this.health = health;
		}
		
		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name = name;
		}		
		
		//Add the attack(Human) method that reduces the health of the attacked human by the strength of the current human.
		public String attack(Human human) {
			human.setHealth(human.getHealth()-this.strength);	
			return "You attacked " + human.getName()  + ". Their new health is: " + human.getHealth();
		}

}
