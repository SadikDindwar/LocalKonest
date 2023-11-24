package com.KodNest;

import java.util.Scanner;

public class ArmStrongNumber {
	public static int getCount(int num) {
		int count =0;
		while (num>0) {
			num=num/10;
			count++;
		}
		return count;
	} 
	public static int getNumber(int num , int count) {
		int sum=0;
		int temp=1;
		while(num>0) {
			int lastDigit=num%10;
			for(int i =1; i<=count; i++) {
				temp=temp*lastDigit;
				
			}
			sum= sum+temp;
			temp=1;
			num=num/10;
			}
		return sum;
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter the number : ");
		int num = sc.nextInt();
		int count=getCount(num);
		int res = getNumber(num , count);
		System.out.println("Result is : "+res);
		if(num==res) {
			System.out.println("Given Number is ArmStrong Number .");
		}
		else {
			System.out.println("Given Number is not ArmStrong Number.");
		}
		
		
	}

}
