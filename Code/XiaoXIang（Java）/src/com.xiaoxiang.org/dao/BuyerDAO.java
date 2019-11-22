package com.xiaoxiang.org.dao;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xiaoxiang.org.vo.Buyer;

/**
 * A data access object (DAO) providing persistence and search support for Buyer
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.xiaoxiang.org.dao.Buyer
 * @author MyEclipse Persistence Tools
 */
public class BuyerDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(BuyerDAO.class);

	public void save(Buyer transientInstance) {
		try {
			session=getSession();
			transation = session.beginTransaction();
			session.save(transientInstance);
			transation.commit();
			closeSession();
		} catch (RuntimeException re) {
			
			throw re;
		}finally {
			closeSession();
		}
	}

	public void delete(Buyer persistentInstance) {
		try {
			session=getSession();
			transation = session.beginTransaction();
			session.save(persistentInstance);
			transation.commit();
			closeSession();
		} catch (RuntimeException re) {
			
			throw re;
		}finally {
			closeSession();
		}
	}

	public Buyer findById(java.lang.Integer id) {
		log.debug("getting Buyer instance with id: " + id);
		try {
			Buyer instance = (Buyer) getSession().get("com.xiaoxiang.org.dao.Buyer", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Buyer instance) {
		log.debug("finding Buyer instance by example");
		try {
			List results = getSession().createCriteria("com.xiaoxiang.org.dao.Buyer").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Buyer instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Buyer as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all Buyer instances");
		try {
			String queryString = "from Buyer";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Buyer merge(Buyer detachedInstance) {
		log.debug("merging Buyer instance");
		try {
			Buyer result = (Buyer) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Buyer instance) {
		log.debug("attaching dirty Buyer instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Buyer instance) {
		log.debug("attaching clean Buyer instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}