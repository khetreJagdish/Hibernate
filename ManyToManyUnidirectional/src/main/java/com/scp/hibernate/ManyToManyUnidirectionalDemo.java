package com.scp.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.scp.hibernate.entity.Student;
import com.scp.hibernate.entity.Subjects;
import com.scp.hibernate.util.HibernateUtil;



/**
 * 
 *      Many To Many with Unidirectional
 *      
 *    	select * from student;
		select * from subjects;
		select * from Student_Subject;
 * 
 * 
 * */
public class ManyToManyUnidirectionalDemo 
{
    public static void main( String[] args )
    {
    	Student student = new Student("Jagdish" ,"Khetre" );
    	Student student2 = new Student("Anik","Singh");
    	
    	 Subjects subject1 = new Subjects("JAVA");
         Subjects subject2 = new Subjects("OOPS");
         Subjects subject3 = new Subjects("DSA");
         
         student.getSubjects().add(subject1);
         student.getSubjects().add(subject2);
         
         student2.getSubjects().add(subject2);
         student2.getSubjects().add(subject3);
         
         
         SessionFactory factory = HibernateUtil.getSessionFactory();
         Session session = factory.openSession();
         Transaction transaction = session.beginTransaction();
         
         session.persist(student);
         session.persist(student2);
         
         transaction.commit();
         session.close();
         
    	
    }
}
