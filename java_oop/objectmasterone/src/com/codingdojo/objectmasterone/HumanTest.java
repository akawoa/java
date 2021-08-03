package com.codingdojo.objectmasterone;

public class HumanTest {

	public static void main(String[] args) {
		Human dababy = new Human("DaBaby");
		Human travisScottFortnite = new Human("Travis Scott");
		System.out.println(dababy.getHealth());
		System.out.println(travisScottFortnite.getHealth());
		System.out.println(dababy.attack(travisScottFortnite));
		System.out.println(travisScottFortnite.getHealth());

	}

}
