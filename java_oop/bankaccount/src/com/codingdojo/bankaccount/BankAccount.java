package com.codingdojo.bankaccount;

public class BankAccount {
	private double checking_Balance;
	private double savings_Balance;
	private String account_owner;
	private static int number_of_accounts;
	private static double total_money_of_all_accounts;

	public BankAccount(String account_owner) {
		this.account_owner = account_owner;
		this.checking_Balance = 0;
		this.savings_Balance = 0;
		number_of_accounts++;
	}

	/*
	 *xCreate a BankAccount class. xThe class should have the following attributes:
	 *x(double) checking balance, (double) savings balance. xCreate a class member
	 *x(static) that has the number of accounts created thus far. xCreate a class
	 * xmember (static) that tracks the total amount of money stored in every account
	 * xcreated. xIn the constructor, be sure to increment the account count. xCreate
	 * xa getter method for the user's checking account balance. xCreate a getter
	 * method for the user's saving account balance. xCreate a method that will
	 * allow a user to deposit money into either the checking or saving, be sure to
	 * add to total amount stored. Create a method to withdraw money from one
	 * balance. Do not allow them to withdraw money if there are insufficient funds.
	 * Create a method to see the total money from the checking and saving. Users
	 * should not be able to set any of the attributes from the class.
	 * 
	 */
	public String deposit(String account_type, int amount_to_deposit) {
		if (account_type == "checking") {
			this.setChecking_Balance(this.getChecking_Balance() + amount_to_deposit);
			total_money_of_all_accounts += amount_to_deposit;
			return "You successfully deposited " + amount_to_deposit + " to your checking account.";
		} else if (account_type == "savings") {
			this.setSavings_Balance(this.getSavings_Balance() + amount_to_deposit);
			total_money_of_all_accounts += amount_to_deposit;
			return "You successfully deposited " + amount_to_deposit + " to your savings account.";
		} else {
			return "Please choose to deposit to either your checking or savings account,";
		}
	}

	public String withdraw(String account_type, int amount_to_withdraw) {
		if (account_type == "checking") {
			if (this.getChecking_Balance() < amount_to_withdraw) {
				return "Sorry, but you have insufficient funds to make this transaction";
			} else {
				this.setChecking_Balance(this.getChecking_Balance() + amount_to_withdraw);
				total_money_of_all_accounts -= amount_to_withdraw;
				return "You successfully withdrew " + amount_to_withdraw + " from your checking account.";
			}
		} else if (account_type == "savings") {
			if (this.getSavings_Balance() < amount_to_withdraw) {
				return "Sorry, but you have insufficient funds to make this transaction";
			} else {
				this.setSavings_Balance(this.getSavings_Balance() + amount_to_withdraw);
				total_money_of_all_accounts -= amount_to_withdraw;
				return "You successfully withdrew " + amount_to_withdraw + " from your savings account.";
			}
		} else {
			return "Please choose to deposit to either your checking or savings account,";
		}
	}
	
	public String view_Total_Balance() {
		double total_balance;
		total_balance = this.getChecking_Balance() + this.getSavings_Balance();
		return "Your current total balance across all accounts is: " + total_balance;
	}

	public static double getTotal_money_of_all_accounts() {
		return total_money_of_all_accounts;
	}

	private static void setTotal_money_of_all_accounts(double total_money_of_all_accounts) {
		BankAccount.total_money_of_all_accounts = total_money_of_all_accounts;
	}

	public double getChecking_Balance() {
		return checking_Balance;
	}

	private void setChecking_Balance(double checking_Balance) {
		this.checking_Balance = checking_Balance;
	}

	public double getSavings_Balance() {
		return savings_Balance;
	}

	private void setSavings_Balance(double savings_Balance) {
		this.savings_Balance = savings_Balance;
	}

	public String getAccount_owner() {
		return account_owner;
	}

	private void setAccount_owner(String account_owner) {
		this.account_owner = account_owner;
	}

	public static int getNumber_of_accounts() {
		return number_of_accounts;
	}

	private static void setNumber_of_accounts(int number_of_accounts) {
		BankAccount.number_of_accounts = number_of_accounts;
	}
}
