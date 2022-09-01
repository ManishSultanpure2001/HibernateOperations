package com.hql.pagination;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.hibernate.Student;

public class HQLPagination {
	public static void main(String[] args) {

		System.out.println("Project started");
		Configuration configuration = new Configuration();
		SessionFactory factory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();

		Session session = factory.openSession();

		Query<Student>query=session.createQuery("from Student",Student.class);
		
		/* Implemanting pagination Using Hibernate */
		query.setFirstResult(0);
		query.setMaxResults(2);
		
		List<Student>list=query.list();
		for (Student student : list) {
			System.out.println(student.getId()+":"+student.getName()+ " : "+student.getCity());
		}
		
		session.close();
		factory.close();
	}
}
