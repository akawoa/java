package com.codingdojo.zookeeperone;

public class Gorilla extends Mammal {
public Gorilla(int energyLevel) {
		super(energyLevel);
		// TODO Auto-generated constructor stub
	}

	//	 Create a separate class Gorilla that can throwSomething(), eatBananas(), and climb()

	public String throwSomething() {
		super.setEnergyLevel(super.getEnergyLevel()-5);
		return "The gorilla has thrown something, new energy level is: " + super.getEnergyLevel();
	}
	
	public String eatBananas() {
		super.setEnergyLevel(super.getEnergyLevel()+10);
		return "The gorilla is most pleased eating bananas. Its new energy level is: " + super.getEnergyLevel();
	}
	
	public String climb() {
		super.setEnergyLevel(super.getEnergyLevel()-10);
		return "The gorilla has climbed a tree, its new energy level is: " + super.getEnergyLevel();
	}
//	  For the throwSomething() method, have it print out a message indicating that the gorilla has thrown something, as well as decrease the energy level by 5
//
//	  For the eatBananas() method, have it print out a message indicating the gorilla's satisfaction and increase its energy by 10
//
//	  For the climb() method, have it print out a message indicating the gorilla has climbed a tree and decrease its energy by 10
	private void sysout() {
		// TODO Auto-generated method stub

	}
}
