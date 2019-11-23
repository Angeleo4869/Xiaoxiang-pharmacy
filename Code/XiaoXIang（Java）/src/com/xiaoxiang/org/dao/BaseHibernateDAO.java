package com.xiaoxiang.org.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.xiaoxiang.org.util.HibernateSessionFactory;


/**
 * Data access object (DAO) for domain model
 * @author MyEclipse Persistence Tools
 */
public class BaseHibernateDAO implements IBaseHibernateDAO {
	
	Session session;
	Transaction transation;
	public Session getSession() {
		return this.session = HibernateSessionFactory.getSession();
	}
	
	public void closeSession(){
		if(session!=null)
		 HibernateSessionFactory.closeSession();
	}
	
}