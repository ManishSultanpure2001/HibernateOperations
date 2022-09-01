package com.firstlevel.caching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.Student;

public class FirstLevelCaching {
public static void main(String[] args) {

	System.out.println("Project started");
//	Configuration configuration = new Configuration();
	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	Session session = factory.openSession();
	/* It is bydefault enabled 
	 * Only one time database will hit whater we are getting more than one time data 
	 * It will not hit again and again for same data only one time will hit the database and save the data in cache
	 * 
	 * */
	
	/* get Student details */
	Student student1=session.get(Student.class,11);
	System.out.println(student1);
	
	
	System.out.println("We are working something");
	
	
	Student student2=session.get(Student.class,11);
	System.out.println(student2);
	
	
	System.out.println(session.contains(student1));
	session.close();
//	System.out.println(session.contains(student1));
	
}
}
