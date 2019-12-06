package com.xiaoxiang.org.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class BaseDAO {
	private SessionFactory sessionFactory;
	protected Transaction transaction;
	protected Session session; 
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession(){
		return sessionFactory.openSession();
	}
	

	public void closeSession(){
			if(session!=null)
			session.close();
	}
		

}
