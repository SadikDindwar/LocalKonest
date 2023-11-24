package com.KodNest;

import java.util.Scanner;
class SortArray{
	//Method for sorting Array in Ascending Order 
	public void arrangeAscending(int [] arr) {
		//Loop for traversing through the Array
		for(int i=0; i<arr.length-1; i++) {
			for(int j=0; j<arr.length-i-1; j++) {
				//sorting logic
				int temp=0;
				if(arr[j]>arr[j+1]) {
				  temp= arr[j];
				  arr[j]=arr[j+1];
				  arr[j+1]=temp;
				}
			}
		}
		System.out.print("Sorted Array is :");
		//loop for printing sorted Array
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}
	//Method for sorting Array in Descending Order 
	public void arrangeDescending(int [] arr) {
		// loop for traversing through Array
		for(int i=0; i<arr.length-1; i++) {
			for(int j=0; j<arr.length-i-1; j++) {
				//Logic for sorting
				int temp=0;
				if(arr[j]<arr[j+1]) {
				  temp= arr[j];
				  arr[j]=arr[j+1];
				  arr[j+1]=temp;
				}
			}
		}
		System.out.print("Sorted Array is :");
		//loop for printing sorted Array
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}
}

public class BubbleSortDemoApp {
	//main method
	public static void main(String[] args) {
		//Creating Scanner Object for taking user input.
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Size of an Array :");
		//Taking size of Array from user
		int len = sc.nextInt();
	//	Creating Array
		int arr[] = new int [len];
		//Taking Array Elements from user and Storing it in Array
		for(int i=0; i<arr.length; i++) {
			System.out.println("Enter Array Elements at Index "+i);
			arr[i]=sc.nextInt();
		}
		//Asking user for Ascending or Descending order of sorting 
		System.out.println("Enter Ascending or Descending Order Sorting :");
		System.out.println("Enter 0 for Ascending order :");
		System.out.println("Enter 1 for Decending order :");
		int n = sc.nextInt();
		//Creating object of SortArray class to use/call its methods.
		SortArray sa = new SortArray();
		if(n==0) {
			//if user has chosen Ascending order sorting then calling arrangeAscending() method
			sa.arrangeAscending(arr);
		}
		else if (n==1) {
			//if user has chosen Descending order sorting then calling arrangeDescending() method. 
			sa.arrangeDescending(arr);
		}
		else {
			//printing message "Invalid input " if user has entered other than 0 and 1.
			System.out.println("Invalid Input.");
		}
		
	}

}
