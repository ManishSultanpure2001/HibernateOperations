package com.criteria.api;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.hibernate.Student;

public class CriteriaAPIExample {
public static void main(String[] args) {

	System.out.println("Project started");
	Configuration configuration = new Configuration();
	SessionFactory factory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();
	Session currentSession = factory.openSession();
	Criteria criteria=currentSession.createCriteria(Student.class);
//	criteria.add(Restrictions.eq("id", 55));// Use For filtering on basis id
	criteria.add(Restrictions.gt("id", 11));// Use For filtering for grater than
	List<Student>list= criteria.list();
	for (Student student : list) {
		System.out.println(student);
	}
	factory.close();
}
}
