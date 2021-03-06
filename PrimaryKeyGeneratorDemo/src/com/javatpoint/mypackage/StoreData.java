package com.javatpoint.mypackage;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StoreData {
public static void main(String[] args) {
	
	//creating configuration object
	Configuration cfg=new Configuration();
	cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file
	
	//creating seession factory object
	SessionFactory factory=cfg.buildSessionFactory();
	
	//creating session object
	Session session=factory.openSession();
	
	//creating transaction object
	Transaction t=session.beginTransaction();

	/**
	 *   primary key autogenerator
	 *   
	 *   1) assigned
		This generator supports in all the databases
		This is the default generator class used by the hibernate, if we do not specify <generator �> element under id element then hibernate by default assumes it as �assigned�
		If generator class is assigned, then the programmer is responsible for assigning the primary key value to object which is going to save into the database
	 * 
	 * 2) Increment
			This generator supports in all the databases, database independent
			This generator is used for generating the id value for the new record by using the formula
			Max of id value in Database + 1

			if we manually assigned the value for primary key for an object, then hibernate doesn�t considers that value and uses max value of id in database + 1 concept only :-)
			If there is no record initially in the database, then for the first time this will saves primary key value as 1, as�
			max of id value in database + 1
			0 + 1
			result -> 1
	 			
	 *   3) sequence
			Not has the support with MySql
			This generator class is database dependent it means, we cannot use this generator class for all the database, we should know whether the database supports sequence or not before we are working with it
			while inserting a new record in a database, hibernate gets next value from the sequence under assigns that value for the new record
			If programmer has created a sequence in the database then that sequence name should be passed as the generator
	 *   
	 *   <id name="productId" column="pid">
		<generator>
		<param name="sequence">MySequence</param>
		</genetator>
		</id>
		
		If the programmer has not passed any sequence name, then hibernate creates its own sequence with name �Hibernate-Sequence� and gets next value from that sequence, and than assigns that id value for new record
		But remember, if hibernate want�s to create its own sequence, in hibernate configuration file, hbm2ddl.auto property must be set enabled
		sql> create sequence MySequence incremented by 5;

		first it will starts with 1 by default
		though you send the primary key value., hibernate uses this sequence concept only
		But if we not create any sequence, then first 1 and increments by 1..bla bla. in this case hibernate creating right..? so ensure we have hbm2ddl.auto enabled in the configuration file
		
		4) identity
		This is database dependent, actually its not working in oracle
		In this case (identity generator) the id value is generated by the database, but not by the hibernate, but in case of increment hibernate will take over this
		this identity generator doesn�t needs any parameters to pass
		this identity generator is similar to increment generator, but the difference was increment generator is database independent and hibernate uses a select operation for selecting max of id before inserting new record
		But in case of identity, no select operation will be generated in order to insert an id value for new record by the hibernate
		
		As this is not working in Oracle
		
		
	 *   
	 *   
	 * */
	
	Employee e1=new Employee();
	//e1.setId(115);                                 /*In case of  "increment" primary auto generator we no need to set id explicetly .*/
	e1.setFirstName("Jack");
	e1.setLastName("sparrow");
	
	Employee e2 = new Employee();
	//e1.setId(115); 
	e2.setFirstName("Jagdish");
	e2.setLastName("Khetre");
	
	session.save(e1);//persisting the object
	session.save(e2);//persisting the object
	
	t.commit();//transaction is commited
	session.close();
	
	System.out.println("successfully saved");
	
}
}
