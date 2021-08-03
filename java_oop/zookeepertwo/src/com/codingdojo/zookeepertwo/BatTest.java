package com.codingdojo.zookeepertwo;

public class BatTest {

	public static void main(String[] args) {
		Bat hewwo = new Bat();
		System.out.println(hewwo.displayEnergy());
		
//		 Create a BatTest class to instantiate a bat and have it attack three towns, eat two humans, and fly twice.
		System.out.println(hewwo.attackTown());
		System.out.println(hewwo.attackTown());
		System.out.println(hewwo.attackTown());
		System.out.println(hewwo.eatHumans());
		System.out.println(hewwo.eatHumans());
		System.out.println(hewwo.fly());
		System.out.println(hewwo.fly());
		
	}

}
