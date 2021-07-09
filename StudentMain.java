package com.te.StudentManagementSystem;

import java.util.Scanner;

public class StudentMain {


	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		char opt;
		do {
			System.out.println("----------------------------------------------------");
			System.out.println("        Welcome To Student Management System");
			System.out.println("----------------------------------------------------");
			System.out.println();
			System.out.println("What do you want to perform ");
			System.out.println("1. Read Data of all the Students");
			System.out.println("2. Read Data of a specific Student");
			System.out.println("3. Update data of an existing student");
			System.out.println("4. Delete data of a specific Student");
			System.out.println("Enter your choice:");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				ReadAllData.readAllData();
				break;
			case 2:
				ReadOneData.read();
				break;
			case 3:
				UpdateData.updateData();
				break;
			case 4:
				DeleteData.delete();
				break;
			default:
				System.out.println("Invalid Choice ");
				break;
			}
			System.out.println();
			System.out.println("Do you want to continue?");
			System.out.println("Enter 'y' for yes or 'n' for no: ");
			opt = scanner.next().charAt(0);
		} while (opt != 'n');
		System.out.println("\nThank You");
	}

}
