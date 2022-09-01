package com.cascade;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.manytoone.mapping.AnswerManyToOne;
import com.manytoone.mapping.QuestionsManyToOne;
import com.onetoone.maping.Questions;

public class CascadeExample {
public static void main(String[] args) {

	System.out.println("Project started");
	Configuration configuration = new Configuration();
	SessionFactory factory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();
	Session session = factory.openSession();

	QuestionsManyToOne questions=new QuestionsManyToOne();
	questions.setQuestion("What is Swing framework"); 	 
	questions.setQuestionId(121);; 	 
	
	AnswerManyToOne ans1=new AnswerManyToOne(110,"It is desktop technology");
	AnswerManyToOne ans2=new AnswerManyToOne(1112,"Desktop");
	AnswerManyToOne ans3=new AnswerManyToOne(31,"Technology");
	
	List<AnswerManyToOne>list=new ArrayList<AnswerManyToOne>();
	list.add(ans1);
	list.add(ans2);
	list.add(ans3);
	questions.setAnswerManyToOnes(list);
	
	Transaction beginTransaction = session.beginTransaction();
	
	/* Before using cascading */
//	session.save(questions);
//	session.save(ans1);
//	session.save(ans2);
//	session.save(ans3);
	
	/* After using cascading */
	session.save(questions);// same work like above but less code for child
	beginTransaction.commit();
}
}
