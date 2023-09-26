package com.jsp.person.bankaccount;

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

		Person person = new Person();
		person.setName("sam");
		person.setEmail("sam@mail");
		person.setCno(7738454074l);

		Account a1 = new Account();
		a1.setBankname("pnb");
		a1.setIfsc("PNB1234");
		a1.setPincode(400705);

		Account a2 = new Account();
		a2.setBankname("mahb");
		a2.setIfsc("MAHB1234");
		a2.setPincode(400275);

		Account a3 = new Account();
		a3.setBankname("icici");
		a3.setIfsc("ICICI1234");
		a3.setPincode(400022);

		List<Account> accounts = new ArrayList<Account>();
		accounts.add(a1);
		accounts.add(a2);
		accounts.add(a3);

		person.setAccounts(accounts);

		a1.setPerson(person);
		a2.setPerson(person);
		a3.setPerson(person);

		entityTransaction.begin();
		entityManager.persist(person);
		entityTransaction.commit();

	}
}
