package com.xiaoxiang.org.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.xiaoxiang.org.util.HibernateSessionFactory;

/**
 * Data access object (DAO) for domain model
 * @author MyEclipse Persistence Tools
 */
public class BaseHibernateDAO implements IBaseHibernateDAO {
	
	protected Session session;
	protected Transaction transation;
	public Session getSession() {
		//FIXME: Implement this method
		session = HibernateSessionFactory.getSession();
		transation = session.beginTransaction();
		return session;
	}
	
	public void closeSession(){
		if(session!=null)
		 HibernateSessionFactory.closeSession();
	}
	
	
}