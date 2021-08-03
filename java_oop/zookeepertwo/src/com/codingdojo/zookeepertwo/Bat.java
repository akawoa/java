package com.codingdojo.zookeepertwo;

public class Bat extends Mammal {

	public Bat() {
		super.setEnergyLevel(300);
	}

//For the fly() method, print the sound a bat taking off and decrease its energy by 50.
//
//For the eatHumans() method, print the so- well, never mind, just increase its energy by 25.
//
//For the attackTown() method, print the sound of a town on fire and decrease its energy by 100.
	public String fly() {
		super.setEnergyLevel(super.getEnergyLevel() - 50);
		return "REEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE, the bat's new energy level is :" + super.getEnergyLevel();
	}

	public String eatHumans() {
		super.setEnergyLevel(super.getEnergyLevel() + 25);
		return "The bat feasts upon tasty hoomans. Its new energy level is: " + super.getEnergyLevel();
	}

	public String attackTown() {
		super.setEnergyLevel(super.getEnergyLevel() - 100);
		return "My leg! The new energy of the bat is: " + super.getEnergyLevel();
	}
}
