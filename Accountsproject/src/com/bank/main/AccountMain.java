package com.bank.main;

import com.bank.exception.InsufficientBalanceException;

public class AccountMain {



		public static void main(String[] args) {


		BankAccount b1 = new BankAccount(100,"Rizwana",12000);


		b1.showDetails();
		try {
			b1.withdraw(13000);
			b1.showDetails();
			
		}
		catch (InsufficientBalanceException e) 
		{
			System.out.println(e.getMessage());
		}
		try {
			b1.deposit(100);
	        b1.showDetails();
		}
		 catch (InvalidDepositException ide)
		{
			System.out.println(ide.getMessage());
		}

		System.out.println("good bye");
		}
}

