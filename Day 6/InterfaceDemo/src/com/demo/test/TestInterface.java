package com.demo.test;

import com.demo.beans.MyClass;
import com.demo.interfaces.Interface1;
import com.demo.interfaces.Intrerface2;

public class TestInterface {
	public static void main(String[] args) {
		MyClass ob=new MyClass();
		ob.combination(5, 2);
		Interface1 ob1=new MyClass();
		ob1.combination(4, 2);
		
		Intrerface2 ob2=new MyClass();
		ob2.m3(); //directly called because function is present in interface 2
		((MyClass)ob2).m2(12); //m2 is not present in interface 2 so it called using class
		ob2.hashCode();		
	}
}
