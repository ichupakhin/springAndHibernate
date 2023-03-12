package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateCourseAndStudentsDemo {

	public static void main(String[] args) {
	
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			
			//Instructor instructor = session.get(Instructor.class, 1);
			Course courseMath = new Course("Math3");
			//Course coursePhysics = new Course("Physics3");

			
			
			System.out.println(courseMath);
			session.save(courseMath);
			//session.save(coursePhysics);
			
			Student student1 = new Student("Hong", "Li", "hl@email.com");
			Student student2 = new Student("Mary", "Li", "ml@email.com");
			
			courseMath.addStudent(student1);
			courseMath.addStudent(student2);
			
			session.save(student1);
			session.save(student2);
			
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
