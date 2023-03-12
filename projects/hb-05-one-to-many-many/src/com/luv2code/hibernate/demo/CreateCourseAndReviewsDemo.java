package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;

public class CreateCourseAndReviewsDemo {

	public static void main(String[] args) {
	
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			
			//Instructor instructor = session.get(Instructor.class, 1);
			Course courseMath = new Course("Math2");
			//Course coursePhysics = new Course("Physics2");
			
			courseMath.add(new Review("Gereat course!"));
			courseMath.add(new Review("Cool course!"));
			courseMath.add(new Review("Dumb course!"));
			
			//instructor.addCourse(courseMath);
			//instructor.addCourse(coursePhysics);
			
			
			System.out.println(courseMath);
			session.save(courseMath);
			//session.save(coursePhysics);
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
