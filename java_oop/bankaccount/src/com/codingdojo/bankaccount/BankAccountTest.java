package com.codingdojo.bankaccount;

public class BankAccountTest {

	public static void main(String[] args) {
		
		BankAccount ryne = new BankAccount("Ryne Rountree");
		System.out.println(ryne.getAccount_owner());
		System.out.println(ryne.getSavings_Balance());
		System.out.println(BankAccount.getTotal_money_of_all_accounts());
		System.out.println(BankAccount.getNumber_of_accounts());
		System.out.println(ryne.deposit("yeet", 0));
		System.out.println(ryne.deposit("checking", 999));
		System.out.println(ryne.getChecking_Balance());
		System.out.println(BankAccount.getTotal_money_of_all_accounts());
		System.out.println(ryne.deposit("savings", 711));
		System.out.println(ryne.getSavings_Balance());
		System.out.println(BankAccount.getTotal_money_of_all_accounts());
		
	}

}
