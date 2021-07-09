package com.te.StudentManagementSystem;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.te.StudentManagemnetSystem.bean.Student;



public class ReadAllData {

	public static void readAllData() {
		
		EntityManagerFactory factory=null;
		EntityManager manager=null;
				
		try {
			factory = Persistence.createEntityManagerFactory("studentData");
			manager = factory.createEntityManager();

			String readDynamic="from Student";
			Query query= manager.createQuery(readDynamic);
			
			List<Student> list= query.getResultList();
			System.out.println("List of Student is:\n");
			for (Student student : list) {
				System.out.println(student);
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
