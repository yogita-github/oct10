package com.demo.test;

import java.util.Arrays;
import java.util.Scanner;

import com.demo.beans.Account;
import com.demo.service.AccountService;
import com.demo.service.AccountServiceImpl;

public class TestAccount {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		AccountService ac=new AccountServiceImpl();
		int choice=0;
		do {
		System.out.println("1. Add new Account\n2. Delete by id\n3. withdrawal\n");
		System.out.println("4. deposit\n5. check balance\n6. display all\n7. exit\n choice :");
		choice=sc.nextInt();
		switch(choice) {
		case 1:
			ac.addnewAccount();
			break;
		case 2:
			System.out.println("enetr acid");
			int id=sc.nextInt();
			System.out.println("Enter pin");
			int pin=sc.nextInt();
			int status=ac.deleteById(id,pin);
			if(status>0) {
				System.out.println("Account closed");
			}else if(status==-1) {
				System.out.println("not found");
			}else {
				System.out.println("pin is wrong");
			}
			break;
		case 3:
			System.out.println("enetr acid");
			 id=sc.nextInt();
			System.out.println("Enter pin");
			 pin=sc.nextInt();
			System.out.println("enetr amount to deposit");
			double amt=sc.nextDouble();
			status= ac.withdrawAmount(id,pin,amt);
			if(status>0) {
				System.out.println("Money Withdrawal done");
			}else if(status==-1) {
				System.out.println("not found");
			}else if(status==-3){
				System.out.println("insufitient balance");
			}else {
				System.out.println("pin is wrong");
			}
			break;
		case 4:
			System.out.println("enetr acid");
			id=sc.nextInt();
			System.out.println("Enter pin");
			 pin=sc.nextInt();
			System.out.println("enetr amount to deposit");
			amt=sc.nextDouble();
			status=ac.depositAmount(id,pin,amt);
			if(status>0) {
				System.out.println("Money deposited");
			}else if(status==-1) {
				System.out.println("not found");
			}else {
				System.out.println("pin is wrong");
			}
			break;
		case 5:
			System.out.println("enetr acid");
			 id=sc.nextInt();
			System.out.println("Enter pin");
			 pin=sc.nextInt();
			double bal=ac.findBalance(id,pin);
			if(bal>0) {
				System.out.println("Balance of account  :"+id+": " +bal);
			}else if(bal==-1) {
				System.out.println("not found");
			}else {
				System.out.println("pin is wrong");
			}
			break;
		case 6:
			Account[] arr=ac.findAll();
			//java 1.7
			for(Account a:arr) {
				if(a!=null)
				   System.out.println(a);
				else
					break;
			}
			//java 1.8
			//Arrays.stream(arr).forEach(ob->{System.out.println(ob);});
			//Arrays.stream(arr).forEach(ob->System.out.println(ob));
			//Arrays.stream(arr).forEach(System.out::println);
			break;
		
		case 7:
			System.out.println("Thank you for visiting....");
			sc.close();
			break;
		default:
			System.out.println("wrong choice");
			break;
		}
		}while(choice!=7);

	}

}
