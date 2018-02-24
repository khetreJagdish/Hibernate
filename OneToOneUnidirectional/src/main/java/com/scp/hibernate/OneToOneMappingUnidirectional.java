package com.scp.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToOneMappingUnidirectional {

	public static void main(String[] args) {
		
		Configuration configuration = new Configuration();
		configuration.configure();
		
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		Student student = new Student();
		student.setFirstName("Jagdish");
		student.setLastName("Khetre");
		student.setSection("JAVA");
		
		Address address = new Address();
		address.setStreet("12 Balaji Nagar");
		address.setCity("Pune");
		address.setCountry("INDIA");
		session.persist(student);
		
		student.setAddress(address);
		address.setId(student.getId());
		session.save(student);
		System.out.println(student);
		
		transaction.commit();
	}

}
