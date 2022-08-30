package com.hibernate;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import sun.security.action.GetBooleanAction;

public class FatchDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Project started");
		Configuration configuration = new Configuration();
		org.hibernate.SessionFactory factory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();
		System.out.println(factory);
		System.out.println(factory.isClosed());
		Session currentSession = factory.openSession();
//		currentSession.beginTransaction();
		
		/* Get Student */
//		 Student student = (Student)currentSession.get(Student.class, 102);
		 Student student = (Student)currentSession.load(Student.class, 102);
		 System.out.println(student);
		 
		  
		 
		 Address address=(Address)currentSession.get(Address.class, 1);
		 System.out.println(address.getCity());
		 System.out.println(address.getStreat());
		 System.out.println(address.getImage());
	}

}
