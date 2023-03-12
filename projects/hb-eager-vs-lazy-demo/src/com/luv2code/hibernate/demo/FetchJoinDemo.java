package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class FetchJoinDemo {

	public static void main(String[] args) {
	
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class)
				.buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			
			Instructor instructor = session.get(Instructor.class, 1);
			
			//Option 1: load courses into memory before the session is closed
			System.out.println("instructor courses: " + instructor.getCourses());
			
			session.getTransaction().commit();
			session.close();
			
			System.out.println("instructor courses: " + instructor.getCourses());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			//session.close();
			sessionFactory.close();
		}
		
		
	}

}
