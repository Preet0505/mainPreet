package com.Emp;

import java.lang.module.Configuration;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DAOServiceImpl {

	static Configuration configuration;
	static SessionFactory factory;
	static Session session;
	static Transaction transaction;

	public static void create(Emp em) {
		try {
			configuration = new Configuration().configure("hibernate.cfg.xml");
			factory = configuration.buildSessionFactory();
			session = factory.openSession();
			transaction = session.beginTransaction();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
		
	}
	}

//		try {
//			configuration = new Configuration().configure("hibernate.cfg.xml");
//			factory = configuration.buildSessionFactory();
//			session = factory.openSession();
//			transaction = session.beginTransaction();
//	}catch(Exception e){
//		
//	}}
//}
