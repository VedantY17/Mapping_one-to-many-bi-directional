package com.jsp.bank.branches;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DriverSave {
	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vedant");

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		EntityTransaction entityTransaction = entityManager.getTransaction();

		Bank bank = new Bank();
		bank.setName("AXIS");

		Branch b1 = new Branch();
		b1.setLocation("Vashi");

		Branch b2 = new Branch();
		b2.setLocation("Kurla");

		Branch b3 = new Branch();
		b3.setLocation("Sion");

		Branch b4 = new Branch();
		b4.setLocation("Bhandup");

		List<Branch> branches = new ArrayList<Branch>();
		branches.add(b1);
		branches.add(b2);
		branches.add(b3);
		branches.add(b4);

		bank.setBranches(branches);

		b1.setBank(bank);
		b2.setBank(bank);
		b3.setBank(bank);
		b4.setBank(bank);

		entityTransaction.begin();
		entityManager.persist(b1);
		entityManager.persist(b2);
		entityManager.persist(b3);
		entityManager.persist(b4);
		entityManager.persist(bank);
		entityTransaction.commit();

	}

}
