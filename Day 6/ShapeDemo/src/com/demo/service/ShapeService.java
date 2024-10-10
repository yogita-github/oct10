package com.demo.service;

import java.util.Scanner;

import com.demo.beans.Circle;
import com.demo.beans.Shape;
import com.demo.beans.Triangle;

public class ShapeService {
	static Shape[] sarr;
	static int cnt;
	static {
		sarr=new Shape[5];
		cnt=0;
	}
	
    //@SuppressWarnings(value = { "" })
	public static void acceptData(int choice) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter color");
		String color=sc.next();
		switch(choice) {
		case 1:
			System.out.println("enter base");
			float b=sc.nextFloat();
			System.out.println("enter height");
			float h=sc.nextFloat();
			System.out.println("enter side1");
			float s1=sc.nextFloat();
			System.out.println("enter side2");
			float s2=sc.nextFloat();
			sarr[cnt]=new Triangle(color,b,h,s1,s2);
			break;
		case 2:
			System.out.println("enter radius");
			float r=sc.nextFloat();
			sarr[cnt]=new Circle(color,r);
			break;
		case 3:
			//rectangle object creation
			break;
		}
		cnt++;
		
	}


	public static void calculateDetails(int pos) {
		System.out.println(pos+" : Area: "+sarr[pos].calcArea());
		System.out.println(pos+" : perimeter: "+sarr[pos].calcPerimeter());
	}


	public static Shape[] getAllShapes() {
		return sarr;
	}
	
	

}
