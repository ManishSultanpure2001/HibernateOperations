package com.hibernate.lifecycle.states;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SharedSessionContract;
import org.hibernate.cfg.Configuration;

import com.hibernate.Certificate;
import com.hibernate.Student;
import com.mysql.cj.xdevapi.SessionFactory;

public class State {

	public static void main(String[] args) throws SecurityException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException {
		/* Precital of hibernate  Object states
		 * Transient
		 * Persistent
		 * Detached
		 * Removed
		 * */
		
		System.out.println("hiii ram");
		Configuration configuration = new Configuration();
		org.hibernate.SessionFactory factory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();

		//Creating Student Object
		Student student=new Student();
		student.setId(55);
		student.setName("Piter");
		student.setCity("Indore");
		student.setCertificate(new Certificate("Java Course","2 Months"));
		
		//student : It is in Transient state

		Session openSession = factory.openSession();
		org.hibernate.Transaction beginTransaction = openSession.beginTransaction();
		openSession.save(student);
		
		
		//student :Persistent - Session ,database
		student.setName("Jhone");
		beginTransaction.commit();
		openSession.close();
		
		//student : Detached state :- Changes(Assosiated) in student but will not update in database
		student.setName("Sachin");
		factory.close();
		//student : It is in Persistent State
	}

}
