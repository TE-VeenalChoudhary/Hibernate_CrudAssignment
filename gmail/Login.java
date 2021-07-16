package com.te.gmail;

import java.util.ArrayList;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Login {
	
	static Account acc;
	static Scanner sc= new Scanner(System.in);
	static EntityManagerFactory factory = null;
	static EntityManager manager = null;
	static EntityTransaction transaction=null;
	public static void loginVallidation(int id,String pass) {
		
		try {
			factory = Persistence.createEntityManagerFactory("gmailDetails");
			manager = factory.createEntityManager();
						
			acc= manager.find(Account.class, id);
			
			if ((acc.getUser_id()==id) && (acc.getPassword().equals(pass))){
				System.out.println("\nLogin Successful\n");
			}else {
				System.out.println("\nInvalid Credentials!!!!!!!!!!!!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (manager != null) {
				manager.close();
			}
			if (factory != null) {
				factory.close();
			}
		}
		
	}
	public static void compose(int id,String pass) {
		try {
			factory = Persistence.createEntityManagerFactory("gmailDetails");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			
			acc= manager.find(Account.class, id);
			Inbox inbox=new Inbox();
			inbox.setMessage_id(3);
			inbox.setMessage("Hello! How are you?");
			inbox.setAccount(acc);

			Inbox inbox1 = new Inbox();
			inbox1.setMessage_id(6);
			inbox1.setMessage("Hello! Who are you?");
			inbox1.setAccount(acc);
			ArrayList<Inbox> array = new ArrayList<Inbox>();
			array.add(inbox);
			array.add(inbox1);
			acc.setInbox(array);
			if ((acc.getUser_id()==id) && (acc.getPassword().equals(pass))){
				System.out.println("Message Composed Successfully");
				manager.persist(acc);
			}else {
				System.out.println("failed");
			}
			
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			if (manager != null) {
				manager.close();
			}
			if (factory != null) {
				factory.close();
			}
		}
	}
	
public static void viewInbox(int id,String pass) {
		
		try {
			factory = Persistence.createEntityManagerFactory("gmailDetails");
			manager = factory.createEntityManager();
						
			acc= manager.find(Account.class, id);
			
			if ((acc.getUser_id()==id) && (acc.getPassword().equals(pass))){
				System.out.println(acc.getInbox());
			}else {
				System.out.println("\nInvalid Credentials!!!!!!!!!!!!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (manager != null) {
				manager.close();
			}
			if (factory != null) {
				factory.close();
			}
		}
		
	}

}
