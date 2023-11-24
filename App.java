package com.kodnest.DOAPattern.DOAPAttern;

import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		System.out.println("Welcome....");
		Scanner sc = new Scanner(System.in);
		EmplloyeeDAOImplementation edi = new EmplloyeeDAOImplementation();

		while (true) {
			System.out.println("Enter Choice");
			System.out.println("Enter 1 for printing all the rows.");
			System.out.println("Enter 2 for Getting Employee row by id:");
			System.out.println("Enter 3 for Inserting row:");
			System.out.println("Enter 4 for updating row:");
			System.out.println("Enter 5 for deleting row:");
			System.out.println("Enter 6 to exit:");
			int choice = sc.nextInt();
			if (choice == 6) {
				System.out.println("Thank you....");
				break;
			}
			else if(choice>0 && choice<=5) {
				switch (choice) {
				case 1:
					List<Employee> emplist = edi.getEmployee();
					break;
				case 2:
					System.out.println("Enter id :");
					int id = sc.nextInt();
					Employee obj = edi.getEmployeeByid(id);
					System.out.println(obj);
					break;
				case 3:
					System.out.println("Enter name:");
					sc.nextLine();
					String name = sc.nextLine();
					System.out.println("Enter department:");
					String department = sc.nextLine();
					Employee e1 = new Employee(name, department);
					String message = edi.persistEmployee(e1);
					System.out.println(message);
					break;
				case 4:
					sc.nextLine();
					System.out.println("Enter the updated department:");
					String upddept= sc.nextLine();
					String update=edi.updateEmployee(upddept);
					System.out.println(update);
					break;
				case 5:
					System.out.println("Enter id to delete row :");
					int delid= sc.nextInt();
					Employee e2= edi.getEmployeeByid(delid);
					String delete=edi.deleteemployee(e2);
					System.out.println(delete);
					break;

				}

			}
			else {
				System.out.println("Please enter valid choice.");
			}
		}
	}
}
