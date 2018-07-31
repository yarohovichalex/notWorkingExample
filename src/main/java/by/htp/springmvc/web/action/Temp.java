package by.htp.springmvc.web.action;

import org.hibernate.Session;
import org.hibernate.Transaction;

import by.htp.springmvc.Entity.User;
import by.htp.springmvc.dao.config.HibernateUtil;

public class Temp {

	public static void main(String[] args) {
	
		Session session = null;
	    Transaction txn = null;
	    try {
	        session = (Session) HibernateUtil.newSessionFactory().openSession();
	        txn = session.beginTransaction();
	 
	        User user = new User();
	        user.setRole("Role");
	        session.persist(user);
	 
	        txn.commit();
	    } catch (RuntimeException e) {
	        if ( txn != null && txn.isActive() ) txn.rollback();
	        throw e;
	    } finally {
	        if (session != null) {
	            session.close();
	        }
	    }
	}
}
