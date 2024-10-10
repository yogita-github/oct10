package com.demo.beans;

import com.demo.interfaces.Interface1;
import com.demo.interfaces.Intrerface2;

public class MyClass implements Interface1,Intrerface2{

	@Override
	public void m3() {
		System.out.println("in m3 myclass");
		
	}

	@Override
	public void m1() {
		System.out.println("in m1 myclass");
		
	}

	@Override
	public int m2(int x) {
		System.out.println("in m2 myclass");
		return x*10;
	}
	

}
