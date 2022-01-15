package com.bank.main;

import com.bank.exception.InsufficientBalanceException;

public class BankAccount 
{ 
	int accountNumber; 
     String name; 
     int balance;

BankAccount (int accno, String name1 , int balance1)
{ 
	accountNumber = accno; name = name1; balance = balance1; 
	}
void withdraw(int amount) throws InsufficientBalanceException
{
	if(balance-amount <1000)
		
	throw new InsufficientBalanceException("existing balance  " + balance +" not sufficient to withdraw " +amount);
	
		balance = balance - amount; 
	} 
void deposit(int amount)
{
	if(amount<500)
		
		throw new InvalidDepositException("deposit should not be less than 500");
	balance= balance+amount;
	}
public void showDetails()
{ 
	System.out.println(); 
	System.out.println("Name " +name);
	System.out.println("Account Number " +accountNumber); 
	System.out.println("Balance " +balance); 
	}
}