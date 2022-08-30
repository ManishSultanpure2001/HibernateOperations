package com.onetoone.maping;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class MapDemo {
public static void main(String ar[]) {
	
	System.out.println("Project started");
	Configuration configuration = new Configuration();
	org.hibernate.SessionFactory factory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();
	
	//Creatig Questions
	
	Questions questions=new Questions();
	questions.setQuestionId(12231);
	questions.setQuestion("What is java");
	

	//Creating Answer
	Answer answer=new Answer();
	answer.setAnserId(12);
	answer.setAnswer("java is programming language");
	answer.setQue(questions);
	questions.setAnswer(answer);
	
	//Creatig Questions
	
		Questions questions1=new Questions();
		questions1.setQuestionId(3);
		questions1.setQuestion("What is Hindi");
		

		//Creating Answer
		Answer answer1=new Answer();
		answer1.setAnserId(1222);
		answer1.setAnswer("Hindi is Indian language");
	questions1.setAnswer(answer1);
	answer1.setQue(questions1);
	Session currentSession = factory.openSession();
	
	 currentSession.save(questions);
	 currentSession.save(questions1);
	 currentSession.save(answer);
	 currentSession.save(answer1);
	
	 System.out.println(questions.toString());
	 System.out.println(questions1.toString());
	 currentSession.beginTransaction().commit();
	 
		/* Fatching Data */
	 
	 Questions getData=(Questions)currentSession.get(Questions.class,3);
	System.out.println("get data=>  "+getData);
	 currentSession.close();
	factory.close();
	
}
}
