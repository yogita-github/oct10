package com.demo.test;

import java.util.Scanner;

import com.demo.beans.Circle;
import com.demo.beans.Shape;
import com.demo.beans.Triangle;
import com.demo.service.ShapeService;

public class TestShape {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int choice=0;
		for(int i=0;i<5;i++) {
		  System.out.println("1. Triangle\n2 Circle\n3. Rectangle\n choice: ");
		  choice=sc.nextInt();
		  ShapeService.acceptData(choice);
		}
		for(int i=0;i<5;i++) {
			ShapeService.calculateDetails(i);
		}
		int cntTraingle=0;
		int cntCircle=0;
		int cntRectangle=0;
		Shape[] sarr=ShapeService.getAllShapes();

		for(int i=0;i<sarr.length;i++) {
			if(sarr[i] instanceof Triangle) {
				cntTraingle++;
			}else if(sarr[i] instanceof Circle) {
				cntCircle++;
			}else {
				cntRectangle++;
			}
			
		}
		System.out.println("Triangle Count: "+cntTraingle);
		
		System.out.println("Circle Count: "+cntCircle);
		System.out.println("Rectangle Count: "+cntRectangle);
		
	}
}