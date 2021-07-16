package com.te.gmail;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Register {

	public static void registerUser() {
	
		Account account = new Account();

		account.setUser_id(445);
		account.setUser_name("Juhi");
		account.setPassword("juhi1234");
		account.setEmail("jc86974@gmail.com");

		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;

		try {
			factory = Persistence.createEntityManagerFactory("gmailDetails");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();

			manager.persist(account);
			System.out.println("Registered Successful");
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
