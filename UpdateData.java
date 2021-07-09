package com.te.StudentManagementSystem;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.te.StudentManagemnetSystem.bean.Student;

public class UpdateData {

	public static void updateData() {

		Scanner sc = new Scanner(System.in);
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;
		System.out.println("Enter the Roll Number of the student whose details you want to update: ");
		int rno = sc.nextInt();

		try {
			factory = Persistence.createEntityManagerFactory("studentData");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			if (manager.find(Student.class, rno)==null) {
				System.out.println("Invalid Roll No");
			}else {
			System.out.println("Do you wish to update name (y/n): ");
			char flag = sc.next().charAt(0);
			System.out.println("Do you wish to update Phone Number (y/n): ");
			char flag2 = sc.next().charAt(0);
			System.out.println("Do you wish to update Date of Birth (y/n): ");
			char flag3 = sc.next().charAt(0);

			if (flag == 'y' && flag2 == 'n' && flag3 == 'n') {
				System.out.println("Enter the updated Name: ");
				String name = sc.next();
				String updateQuery = "update Student set Name= :name where RollNo= :rno ";
				Query query = manager.createQuery(updateQuery);
				query.setParameter("name", name);
				query.setParameter("rno", rno);
				int result = query.executeUpdate();
				if (result != 0) {
					System.out.println("Data Updated Successfully");
				}
			} else if (flag == 'y' && flag2 == 'y' && flag3 == 'n') {
				System.out.println("Enter the updated Name: ");
				String name = sc.next();
				System.out.println("Enter the updated Phone Number: ");
				long phn = sc.nextLong();
				String updateQuery = "update Student set Name= :name, PhoneNo= :phn where RollNo= :rno ";
				Query query = manager.createQuery(updateQuery);
				query.setParameter("name", name);
				query.setParameter("rno", rno);
				query.setParameter("phn", phn);
				int result = query.executeUpdate();
				if (result != 0) {
					System.out.println("Data Updated Successfully");
				}
			} else if (flag == 'y' && flag2 == 'y' && flag3 == 'y') {
				System.out.println("Enter the updated Name: ");
				String name = sc.next();
				System.out.println("Enter the updated Phone Number: ");
				long phn = sc.nextLong();
				System.out.println("Enter the updated Date of Birth: ");
				String date = sc.next();
				Date dob=new SimpleDateFormat("dd/MM/yyyy").parse(date);
				java.sql.Date sqlDate=new java.sql.Date(dob.getTime());
				String updateQuery = "update Student set Name= :name, PhoneNo= :phn, DateOfBirth= :dob where RollNo= :rno ";
				Query query = manager.createQuery(updateQuery);
				query.setParameter("name", name);
				query.setParameter("rno", rno);
				query.setParameter("phn", phn);
				query.setParameter("dob", sqlDate);
				int result = query.executeUpdate();
				if (result != 0) {
					System.out.println("Data Updated Successfully");
				}
			} else if (flag == 'n' && flag2 == 'y' && flag3 == 'y') {
				System.out.println("Enter the updated Phone Number: ");
				long phn = sc.nextLong();
				System.out.println("Enter the updated Date of Birth: ");
				String date = sc.next();
				Date dob=new SimpleDateFormat("dd/MM/yyyy").parse(date);
				java.sql.Date sqlDate=new java.sql.Date(dob.getTime());
				String updateQuery = "update Student set PhoneNo= :phn, DateOfBirth= :dob where RollNo= :rno ";
				Query query = manager.createQuery(updateQuery);
				query.setParameter("rno", rno);
				query.setParameter("phn", phn);
				query.setParameter("dob", sqlDate);
				int result = query.executeUpdate();
				if (result != 0) {
					System.out.println("Data Updated Successfully");
				}
			} else if (flag == 'y' && flag2 == 'n' && flag3 == 'y') {
				System.out.println("Enter the updated Name: ");
				String name = sc.next();
				System.out.println("Enter the updated Date of Birth: ");
				String date = sc.next();
				Date dob=new SimpleDateFormat("dd/MM/yyyy").parse(date);
				java.sql.Date sqlDate=new java.sql.Date(dob.getTime());
				String updateQuery = "update Student set Name= :name, DateOfBirth= :dob where RollNo= :rno ";
				Query query = manager.createQuery(updateQuery);
				query.setParameter("name", name);
				query.setParameter("rno", rno);
				query.setParameter("dob", sqlDate);
				int result = query.executeUpdate();
				if (result != 0) {
					System.out.println("Data Updated Successfully");
				}
			} else if (flag == 'n' && flag2 == 'y' && flag3 == 'n') {
				System.out.println("Enter the updated Phone Number: ");
				long phn = sc.nextLong();
				String updateQuery = "update Student set PhoneNo= :phn where RollNo= :rno ";
				Query query = manager.createQuery(updateQuery);
				query.setParameter("rno", rno);
				query.setParameter("phn", phn);
				int result = query.executeUpdate();
				if (result != 0) {
					System.out.println("Data Updated Successfully");
				}
			} else if (flag == 'n' && flag2 == 'n' && flag3 == 'y') {
				System.out.println("Enter the updated Date of Birth: ");
				String date = sc.next();
				Date dob=new SimpleDateFormat("dd/MM/yyyy").parse(date);
				java.sql.Date sqlDate=new java.sql.Date(dob.getTime());
				String updateQuery = "update Student set DateOfBirth= :dob where RollNo= :rno ";
				Query query = manager.createQuery(updateQuery);
				query.setParameter("rno", rno);
				query.setParameter("dob", sqlDate);
				int result = query.executeUpdate();
				if (result != 0) {
					System.out.println("Data Updated Successfully");
				}
			} else {
				System.out.println("Nothing to Update!!!!!!");
			}
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
