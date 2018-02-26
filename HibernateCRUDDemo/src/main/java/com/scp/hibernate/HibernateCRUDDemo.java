package com.scp.hibernate;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.scp.entity.Student;
import com.scp.util.HibernateUtil;

/**
 * Hello world!
 *
 */
public class HibernateCRUDDemo {

	static Logger logger = Logger.getLogger(HibernateCRUDDemo.class);

	public static void main(String[] args) {
		HibernateCRUDDemo crudDemo = new HibernateCRUDDemo();
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		crudDemo.createStudent();
		crudDemo.readStudents();
		Student student2 = new Student();
		student2.setStudentName("Abc Xyz");
		student2.setRollNumber(20);
		student2.setCourse("B.C.A.");
		crudDemo.updateStudent(student2);
		
		
		Student student3 = new Student();
		student2.setStudentName("Abc PQR");
		student2.setRollNumber(25);
		student2.setCourse("B.Tech");
		
		crudDemo.deleteStudent(student3);
		
		transaction.commit();
		session.close();
		sessionFactory.close();
	}

	public void createStudent() {

		Student student1 = new Student();
		student1.setStudentName("Jagdish Khetre");
		student1.setRollNumber(1);
		student1.setCourse("B.Tech.");
		

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		session.save(student1);
		
		logger.info("Inserted Successfully");

		transaction.commit();
		session.close();

	}

	public void readStudents() {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Query query = session.createQuery("from Student");
		List<Student> students = query.list();
		for (Student student1 : students) {
			logger.info("Roll Number: " + student1.getRollNumber() + ", Student Name: " + student1.getStudentName()
					+ ", Course: " + student1.getCourse());
		}

		transaction.commit();
		session.close();

	}
	
	public void updateStudent(Student student) {
		
		logger.info("Student : "+student);
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		logger.error("This is NullPointerException");
		  student.setStudentName("Abc Xyz");
		  
		 logger.info("Updated Successfully");
		  transaction.commit();
		  session.close();
	}
	
	public void deleteStudent(Student student) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		  Session session = sessionFactory.openSession();
		  Transaction transaction = session.beginTransaction();
		  session.delete(student);
		  logger.info("Deleted Successfully");
		  transaction.commit();
		    session.close();
	}
	

}
