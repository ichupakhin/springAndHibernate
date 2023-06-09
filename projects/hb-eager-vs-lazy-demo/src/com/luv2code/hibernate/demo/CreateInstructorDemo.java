package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateInstructorDemo {

	public static void main(String[] args) {
	
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class)
				.buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		try {
			
			Instructor instructor = new Instructor("Max", "Mustermann", "mm@email.com");
			InstructorDetail instructorDetail = new InstructorDetail("mmYoutube", "sports");
			Course course = new Course("Math");
			instructor.setInstructorDetail(instructorDetail);
			instructor.addCourse(course);
			
			session.beginTransaction();
			session.save(instructor);
			session.getTransaction().commit();
			System.out.println("Done!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
			sessionFactory.close();
		}
		
		
	}

}
