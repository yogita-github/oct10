package com.demo.service;

import java.util.Scanner;

import com.demo.beans.Account;

public class AccountServiceImpl implements AccountService{
    static Account[] acarr;
    static int cnt;
    static {
    	acarr=new Account[100];
    	acarr[0]=new Account(1,"Rajan",345676,1111);
    	acarr[1]=new Account(2,"Atharva",345688,2222);
    	cnt=2;
    }
    
	@Override
	public void addnewAccount() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter id");
		int acid=sc.nextInt();
		System.out.println("Enter accountholder name");
		String nm=sc.next();
		System.out.println("Enter account balance");
		double bal=sc.nextDouble();
		System.out.println("Enter account pin");
		int pin=sc.nextInt();
		acarr[cnt]=new Account(acid,nm,bal,pin);
		cnt++;
		
	}
	@Override
	public Account[] findAll() {
		return acarr;
	}
	
	// To find account by Id
	private int findAccountById(int id,int pin) {
		for(int i=0;i<acarr.length;i++) {
			if(acarr[i].getAccid()==id) {
				if(acarr[i].getPin()==pin) {
					return i;
				}else {
					return -2;
				}
			}
				
		}
		return -1;
	}
//	To find the balance
	@Override
	public double findBalance(int id, int pin) {
		int pos=findAccountById(id,pin);
		if(pos>=0) {
			return acarr[pos].getBalance();
		}
		return pos;
	}
//	To deposit amount
	@Override
	public int depositAmount(int id, int pin, double amt) {
		int pos=findAccountById(id, pin);
		if(pos>=0) {
		    acarr[pos].deposit(amt);
		   
		}
		return pos;
	}
//	To withdraw amount
	@Override
	public int withdrawAmount(int id, int pin, double amt) {
		int pos=findAccountById(id, pin);
		if(pos>=0) {
		    boolean status=acarr[pos].withdraw(amt);
		    if(status) {
		    	return 1;
		    }else {
		    	return -3;
		    }
		   
		}
		return pos;
	}
	
	// To delete account
	@Override
	public int deleteById(int id, int pin) {
		int pos=findAccountById(id, pin);
		if(pos>=0) {
			for(int i=pos;i<cnt;i++) {
				acarr[i]=acarr[i+1];
			}
			
		}
		return pos;
	}

}
