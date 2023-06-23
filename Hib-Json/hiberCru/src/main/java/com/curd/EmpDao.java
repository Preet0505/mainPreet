package com.curd;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class EmpDao {

	private static Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Emp.class);
	private static SessionFactory sf = con.buildSessionFactory();;
//	private static Session session = sf.openSession();
//	private static Transaction tx = session.beginTransaction();
	
	
	
	public static void save (Emp e) {
		
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(e);
		tx.commit();
		session.close();	
	}
	
public static List<Emp> getemployee() {

	Session session = sf.openSession();
	Transaction tx = session.beginTransaction();
		
		@SuppressWarnings("unchecked")
		List<Emp> list = session.createQuery("From Emp").getResultList();
			
			
			for (Emp e : list) {
				System.out.println(e.getId()+" "+e.getName()+" "+e.getEmail()+" "+e.getPassword() );
			}
		
			tx.commit();
			session.close();
	
		
		return list;
		
	}
	
public static Emp getIdDetails(int id) {
	Session session = sf.openSession();
	Transaction tx = session.beginTransaction();
	
	Emp employee = session.get(Emp.class, id);
	tx.commit();
	session.close();
	return employee;
	
}



public static void deleteUser(int id) {

	Session session = sf.openSession();
	Transaction tx = session.beginTransaction();
	
	Emp emp = session.get(Emp.class, id);
	session.delete(emp);
	tx.commit();
	session.close();

}



public static void updateDetails(Emp e) {
	Session session = sf.openSession();
	Transaction tx = session.beginTransaction();
	
	session.update(e);
	tx.commit();
	session.close();
}
		
		
}


