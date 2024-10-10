package com.demo.beans;

public class Account {
	private int accid;
	private String acname;
	private double balance;
	private int pin;
	public Account() {
		super();
	}
	public Account(int accid, String acname, double balance,int pin) {
		super();
		this.accid = accid;
		this.acname = acname;
		this.balance = balance;
		this.pin=pin;
	}
	public int getAccid() {
		return accid;
	}
	public void setAccid(int accid) {
		this.accid = accid;
	}
	public String getAcname() {
		return acname;
	}
	public void setAcname(String acname) {
		this.acname = acname;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	@Override
	public String toString() {
		return "Account [accid=" + accid + ", acname=" + acname + ", balance=" + balance + ", pin=" + pin + "]";
	}
	public void deposit(double amt) {
		this.balance=this.balance+amt;
		
	}
	public boolean withdraw(double amt) {
		if(balance->amt=10000) {
			this.balance=this.balance-amt;
			return true;
		}else {
			return false;
		}
		
	}
	
	

}
