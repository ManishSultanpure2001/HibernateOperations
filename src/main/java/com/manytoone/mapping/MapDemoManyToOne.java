package com.manytoone.mapping;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class MapDemoManyToOne {
public static void main(String ar[]) {
	
	System.out.println("Project started");
	Configuration configuration = new Configuration();
	org.hibernate.SessionFactory factory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();
	
	//Creatig Questions
	
	QuestionsManyToOne questions=new QuestionsManyToOne();
	questions.setQuestionId(124 );
	questions.setQuestion("What is java");
	

	//Creating Answer
	AnswerManyToOne answer1=new AnswerManyToOne();
	answer1.setAnserId(111);
	answer1.setAnswer("java is programming language");
	answer1.setQue(questions);
	
	
	AnswerManyToOne answer2=new AnswerManyToOne();
	answer2.setAnserId(1222);
	answer2.setAnswer("It has different Frameworks");
	answer2.setQue(questions);
	
	
	
	AnswerManyToOne answer3=new AnswerManyToOne();
	answer3.setAnserId(1333);
	answer3.setAnswer("We can create softwares by it");
	answer3.setQue(questions);
	
	List<AnswerManyToOne> list=new ArrayList<AnswerManyToOne>();
	
	list.add(answer1);
	list.add(answer2);
	list.add(answer3);
	
	questions.setAnswerManyToOnes(list);
		Session currentSession = factory.openSession();
	 
	 currentSession.save(questions);
	 currentSession.save(answer1);
	 currentSession.save(answer2);
	 currentSession.save(answer3);
	 
	 currentSession.beginTransaction().commit();
	 
		/* Fatching Data */
	 
	 QuestionsManyToOne getData=(QuestionsManyToOne)currentSession.get(QuestionsManyToOne.class,122);
//	System.out.println("get data=>  "+getData);
//	
//	for(AnswerManyToOne actualData:getData.getAnswerManyToOnes()) {
//		System.out.println(actualData.getQue());
		System.out.println(getData.getQuestion().length());
//	}
	 currentSession.close();
	factory.close();
	
}
}
