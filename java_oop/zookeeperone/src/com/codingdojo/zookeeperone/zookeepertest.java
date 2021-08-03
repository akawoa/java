package com.codingdojo.zookeeperone;

public class zookeepertest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		 Create a GorillaTest class to instantiate a gorilla and have it throw three things, eat bananas twice, and climb once.
		Mammal human = new Mammal(10);
		System.out.println(human.displayEnergy());
		Gorilla unga = new Gorilla(100);
		System.out.println(unga.displayEnergy());
		System.out.println(unga.throwSomething());
		System.out.println(unga.throwSomething());
		System.out.println(unga.throwSomething());
		System.out.println(unga.displayEnergy());
		System.out.println(unga.climb());
		System.out.println(unga.displayEnergy());
		System.out.println(unga.eatBananas());
		System.out.println(unga.eatBananas());
		
		
		
		
		
		
		
		
		
	}

}
