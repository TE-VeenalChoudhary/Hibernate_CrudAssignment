package com.te.StudentManagementSystem;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.te.StudentManagemnetSystem.bean.Student;

public class ReadOneData {

	public static void read() {

		EntityManagerFactory factory = null;
		EntityManager manager = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Roll Number of the student whose details you want to view: ");
		int rno = sc.nextInt();
		try {
			factory = Persistence.createEntityManagerFactory("studentData");
			manager = factory.createEntityManager();
			String readDynamic = "from Student where RollNo= :rno";
			Query query = manager.createQuery(readDynamic);

			query.setParameter("rno", rno);

			Student student = (Student) query.getSingleResult();
			System.out.println(student);
		}

		catch (Exception e) {
			System.out.println("Invalid Roll No!!!!!!!!!!!!!!!!!");
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
