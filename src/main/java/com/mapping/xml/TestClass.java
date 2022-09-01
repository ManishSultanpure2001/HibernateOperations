package com.mapping.xml;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestClass {
public static void main(String[] args) {

	System.out.println("Project started");
	Configuration configuration = new Configuration();
	SessionFactory factory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();
	
	Person person=new Person(12, "Arun", "schem number 136", "9826615269");
	Session currentSession = factory.openSession();
	org.hibernate.Transaction transaction=currentSession.beginTransaction();
	currentSession.save(person);
	transaction.commit();
	currentSession.close();
	factory.close();
}
}
