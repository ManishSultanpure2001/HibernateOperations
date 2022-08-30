package com.hibernate;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.boot.archive.internal.FileInputStreamAccess;
import org.hibernate.cfg.Configuration;

import com.mysql.cj.xdevapi.SessionFactory;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws IOException {
		System.out.println("Project started");
		Configuration configuration = new Configuration();
		org.hibernate.SessionFactory factory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();
		System.out.println(factory);
		System.out.println(factory.isClosed());
		Session currentSession = factory.openSession();
		currentSession.beginTransaction();
		
		Student st = new Student();
		st.setId(102);
		st.setName("Manish");
		st.setCity("Indore");

		/* Creating second objecy */
		Address address = new Address();
		address.setStreat("Streat1");
		address.setCity("Delhi");
		address.setOpen(true);
		address.setAddedDate(new java.util.Date());
		address.setX(2003.23);
		
		/* Image reading */

		try {
			FileInputStream fileInputStream=new FileInputStream("src/main/java/com/hibernate/BackgroundOfBook.png");
		
			byte[] data=new byte[fileInputStream.available()];
			fileInputStream.read(data);
			address.setImage(data);
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		/* Save in database */
		currentSession.save(st);
		currentSession.save(address);
		
		currentSession.getTransaction().commit();
		System.out.println(st.toString());
		factory.close();
	}
}
