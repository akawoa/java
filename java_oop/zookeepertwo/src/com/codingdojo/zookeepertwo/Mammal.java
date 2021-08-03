package com.codingdojo.zookeepertwo;

public class Mammal {
	private int energyLevel;
	
	public Mammal () {
		this.energyLevel = 300;
	}

	public int getEnergyLevel() {
		return energyLevel;
	}

	public void setEnergyLevel(int energyLevel) {
		this.energyLevel = energyLevel;
	}
	
	public String displayEnergy() {
		return "The energy level of this animal is: " + this.energyLevel;
	}
	
//	 Create a Mammal class that has an energyLevel and displayEnergy() method. The displayEnergy() method should show the animals energy level as well as return it.
}
