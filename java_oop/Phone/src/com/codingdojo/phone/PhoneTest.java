package com.codingdojo.phone;

public class PhoneTest {

	public static void main(String[] args) {
		Galaxy s21 = new Galaxy("S21", 99, "T-Mobile", "Ring on 'em");
		IPhone iphone20 = new IPhone("20", 98, "AT&T", "Bruh");
		
		s21.displayInfo();
		System.out.println(s21.ring());
		System.out.println(s21.unlock());
		
		iphone20.displayInfo();
		System.out.println(iphone20.ring());
		System.out.println(iphone20.unlock());		
		
		
	}

}
