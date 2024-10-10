package com.demo.test;

import java.util.Scanner;

public class TestArray {

	public static void main(String[] args) {
		int[][] arr=new int[3][];
		Scanner sc=new Scanner(System.in);
		//int[][][] arr1=new int[3][3][];
		//int[][] arr2=new int[4][];
		//int[][] arr3=new int[][5]; //error
		//arr.length --->number of rows
		//accept data int the dynamic array
			for(int i=0;i<arr.length;i++) {
			System.out.println("enter number of columns in row : "+i);
			int c=sc.nextInt();
			//allocate memory for columns of row i
			arr[i]=new int[c];
			for(int j=0;j<arr[i].length;j++) {
				System.out.println("enetr number for row "+i+" column "+j);
				arr[i][j]=sc.nextInt();
			}
			
		}
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				System.out.print(arr[i][j]+"\t");
			}
			System.out.println();
		}
	}

}
