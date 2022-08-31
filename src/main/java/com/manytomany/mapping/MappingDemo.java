package com.manytomany.mapping;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MappingDemo {
	public static void main(String ar[]) {
		
		System.out.println("Project started");
		Configuration configuration = new Configuration();
		org.hibernate.SessionFactory factory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();

		Emp emp1=new Emp();
		emp1.setEid(1);
		emp1.setName("Manish");
		
		Emp emp2=new Emp();
		emp2.setEid(2);
		emp2.setName("Rohan");
		
		Project project1=new Project();
		project1.setPid(11);
		project1.setProjectName("Panda");
		
		
		Project project2=new Project();
		project2.setPid(12);
		project2.setProjectName("Facebook");
		
		List<Emp> empsList =new ArrayList<Emp>();
		List<Project> projectList =new ArrayList<Project>();
		
		empsList.add(emp1);
		empsList.add(emp2);
		
		projectList.add(project1);
		projectList.add(project2);

		emp1.setProjects(projectList);
		project2.setEmps(empsList);
		
		
		Session openSession = factory.openSession();
		Transaction beginTransaction = openSession.beginTransaction();
		openSession.save(emp1);
		openSession.save(emp2);
		openSession.save(project1);
		openSession.save(project2);
		beginTransaction.commit();
	}
}
