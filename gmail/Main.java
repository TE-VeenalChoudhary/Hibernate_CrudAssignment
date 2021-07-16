package com.te.gmail;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("------------------------------------------");
		System.out.println("           Welcome to Gmail");
		System.out.println("------------------------------------------");
		System.out.println("\nWhat do you want to perform");
		System.out.println("Press 1 to login");
		System.out.println("Press 2 to register");
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			System.out.println("Enter your User Id:");
			int id=sc.nextInt();
			System.out.println("Enter your password:");
			String pass=sc.next();
			Login.loginVallidation(id,pass);
			System.out.println("What to you want to do?");
			System.out.println("1. Compose");
			System.out.println("2. View Inbox");
			int opt=sc.nextInt();
			switch (opt) {
			case 1:
				Login.compose(id, pass);
				break;
			case 2:
				Login.viewInbox(id, pass);
				break;
			default:
				break;
			}
			break;
		case 2:Register.registerUser();
			break;
		default:System.out.println("Invalid Choice!!!!!!!!!!!!!!!");
			break;
		}
	}

}
