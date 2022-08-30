package com.hibernate;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class EmbadDemo {

	public static void main(String[] args) throws SecurityException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException {
		// TODO Auto-generated method stub

		
		Configuration configuration = new Configuration();
		org.hibernate.SessionFactory factory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();
		System.out.println(factory);
		System.out.println(factory.isClosed());
		Session currentSession = factory.openSession();
		 
	
		 
		Student student=new Student();
		student.setId(12);
		student.setName("Ramesh");
		student.setCity("Mumbai");
		
		Certificate certificate=new Certificate();
		certificate.setCourse("Android");
		certificate.setDuration("2 months");
		
		student.setCertificate(certificate);
		
		currentSession.save(student);
		currentSession.beginTransaction().commit();
		factory.close();
		currentSession.close();
	}

}

