package testCode;

import java.util.concurrent.locks.*;

public class BankAccount {

	private double balance;
	private Lock bankLock = new ReentrantLock();
	private Condition sufficientFunds = bankLock.newCondition();
	
	public BankAccount() {
	  this.balance = 0;
	}
	
	public void deposit(double amount) throws InterruptedException {
	  bankLock.lock();
	 
	  try {
		 System.out.println("Depositing: " + amount);
	     double newBalance = balance + amount;
	     System.out.println("New Balance: " + newBalance);
	     this.balance = newBalance;
	     sufficientFunds.signalAll();
	  }
	  finally {
	     bankLock.unlock();
	  }
	}
	
	
	public void withdraw(double amount) throws InterruptedException {
	  bankLock.lock();
	  try  {
		  
	     while (balance < amount)
	        sufficientFunds.await();
	    
	     System.out.println("Withdrawing: " + amount);
	     double newBalance = balance - amount;
	     System.out.println("New balance: " + newBalance);
	     balance = newBalance;
	  }
	  finally  {
	     bankLock.unlock();
	  }
	}
	
	public double getBalance() {
	  bankLock.lock();
	  try  {
	     return balance;
	  }
	  finally  {
	     bankLock.unlock();
	  }
	}
}
