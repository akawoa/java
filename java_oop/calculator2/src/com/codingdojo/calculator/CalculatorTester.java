package com.codingdojo.calculator;

public class CalculatorTester {

	public static void main(String[] args) {
		Calculator ZeroTwo = new Calculator();
		ZeroTwo.setOperandOne(0);
		ZeroTwo.setOperandTwo(2);
		ZeroTwo.setOperation("+");
		System.out.println(ZeroTwo.performOperation());
		System.out.println(ZeroTwo.getResults());
		ZeroTwo.setOperandOne(0);
		ZeroTwo.setOperandTwo(2);
		ZeroTwo.setOperation("");
		ZeroTwo.setOperation("-");
		System.out.println(ZeroTwo.performOperation());
		System.out.println("Darling 0" + ZeroTwo.getResults());
		
		ZeroTwo.setOperandOne(9);
		ZeroTwo.setOperandTwo(1000);
		ZeroTwo.setOperation("*");
		System.out.println(ZeroTwo.performOperation());
		System.out.println(ZeroTwo.getResults());
		
		ZeroTwo.setOperandOne(100);
		ZeroTwo.setOperandTwo(1.1);
		ZeroTwo.setOperation("/");
		System.out.println(ZeroTwo.performOperation());
		System.out.println(ZeroTwo.getResults());

	}

}
