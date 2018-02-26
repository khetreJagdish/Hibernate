package com.scp.util;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class HibernateUtil {
		
	static Logger logger = Logger.getLogger(HibernateUtil.class);
	
	 private static final SessionFactory sessionFactory;
	 static
	 {
	  try
	  {
	   sessionFactory = new Configuration().configure().buildSessionFactory();
	  }
	  catch(Throwable th){
	   logger.error("Enitial SessionFactory creation failed"+th);
	   throw new ExceptionInInitializerError(th);
	  }
	   }
	   public static SessionFactory getSessionFactory(){
	    return sessionFactory;
	   }
}
