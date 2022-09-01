package com.hql;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.hibernate.Student;

public class HQLExample {
	public static void main(String[] args) throws SecurityException, RollbackException, HeuristicMixedException,
			HeuristicRollbackException, SystemException {

		System.out.println("Project started");
		Configuration configuration = new Configuration();
		SessionFactory factory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();

		Session session = factory.openSession();
		/*
		 * HQL Syntext
		 */

//	String s="from Student";
//	String s="from Student where id=10";
		/* By Using Outside variable */
		String s = "from Student where id=:x";

		org.hibernate.query.Query query = session.createQuery(s);

		query.setParameter("x", 10);

		/* get Single User */
//	((org.hibernate.query.Query) query).uniqueResult();

		/* get All users */

		List<Student> list = ((org.hibernate.query.Query) query).list();
		for (Student student : list) {
			System.out.println(student.getName() + ":" + student.getCertificate().toString());
		}

		/* Delete Query */
		System.out.println("___________________________________________");

//	
		org.hibernate.Transaction transaction = session.beginTransaction();
//			org.hibernate.query.Query query2=session.createQuery("delete from Student s where s.name=:c");
//			
//			query2.setParameter("c", "Piter");
//			int row=((javax.persistence.Query) query2).executeUpdate();
//			System.out.println("Deleted = "+row);
//	

		/* Update Student */

		org.hibernate.query.Query query3 = session.createQuery("update Student set city=:c where name=:n");
		query3.setParameter("c", "Delhi");
		query3.setParameter("n", "Jhone");
		int row1 = ((javax.persistence.Query) query3).executeUpdate();
		System.out.println("Updated = " + row1);

		transaction.commit();

		/* Joins Query */
		Query query4 = session
				.createQuery("select q.question,q.questionId,a.answer from Questions as q INNER JOIN q.answer as a");

		List<Object[]> list2 = query4.getResultList();

//		System.out.println(list2);

		for (Object[] arr : list2) {
			System.out.println(Arrays.toString(arr));
		}
		session.close();
		factory.close();
	}
}
