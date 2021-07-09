package com.te.StudentManagementSystem;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DeleteData {

	public static void delete() {
		Scanner sc = new Scanner(System.in);
		EntityManagerFactory factory=null;
		EntityManager manager=null;
		EntityTransaction transaction=null;
		System.out.println("Enter the Roll Number of the student whose details you want to delete: ");
		int rn = sc.nextInt();
		
		try {
			factory = Persistence.createEntityManagerFactory("studentData");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();

			String deleteData="delete Student where RollNo= :rn ";
			Query query= manager.createQuery(deleteData);
			query.setParameter("rn", rn);
			int result=query.executeUpdate();
			
			if (result!=0) {
				System.out.println("Data Deleted Successfully");
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

}
