package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class EagerLazyDemo {

	public static void main(String[] args) {
	
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class)
				.buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			

			//Option 2 Use HQL
			Query<Instructor> query = session.createQuery("select i from Instructor i " + "JOIN FETCH i.courses " + "where i.id=:theInstructorId", Instructor.class);
			query.setParameter("theInstructorId", 1);
			
			Instructor instructor = query.getSingleResult();
			
			
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
