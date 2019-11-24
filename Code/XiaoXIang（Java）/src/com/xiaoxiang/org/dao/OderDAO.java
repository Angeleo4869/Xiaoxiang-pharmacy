package com.xiaoxiang.org.dao;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xiaoxiang.org.vo.Admin;
import com.xiaoxiang.org.vo.Oder;

/**
 * A data access object (DAO) providing persistence and search support for Oder
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.xiaoxiang.org.dao.Oder
 * @author MyEclipse Persistence Tools
 */
public class OderDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(OderDAO.class);
	// property constants
	public static final String ODER_STATE = "oderState";

	public boolean save(Oder transientInstance) {
		try {
			session=getSession();
			transation = session.beginTransaction();
			session.save(transientInstance);
			transation.commit();
			closeSession();
			return true;
		} catch (RuntimeException re) {
			throw re;
			//return false;
		}finally {
			closeSession();
		}
	}

	public boolean delete(Oder persistentInstance) {
		try {
			session=getSession();
			transation = session.beginTransaction();
			persistentInstance = session.get(Oder.class, persistentInstance);
			session.delete(persistentInstance);
			transation.commit();
			closeSession();
			return true;
		} catch (RuntimeException re) {
			
			throw re;
		}finally {
			closeSession();
		}
	}

	public Oder findById(java.lang.Integer id) {
		log.debug("getting Oder instance with id: " + id);
		try {
			Oder instance = (Oder) getSession().get("com.xiaoxiang.org.dao.Oder", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Oder instance) {
		log.debug("finding Oder instance by example");
		try {
			List results = getSession().createCriteria("com.xiaoxiang.org.dao.Oder").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Oder instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Oder as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByOderState(Object oderState) {
		return findByProperty(ODER_STATE, oderState);
	}

	public List findAll() {
		log.debug("finding all Oder instances");
		try {
			String queryString = "from Oder";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Oder merge(Oder detachedInstance) {
		log.debug("merging Oder instance");
		try {
			Oder result = (Oder) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public boolean attachDirty(Oder instance) {
		try {
			session=getSession();
			transation = session.beginTransaction();
			instance = session.get(Oder.class, instance);
			session.delete(instance);
			transation.commit();
			closeSession();
			return true;
		} catch (RuntimeException re) {
			throw re;
		}finally {
			closeSession();
		}
	}

	public void attachClean(Oder instance) {
		log.debug("attaching clean Oder instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}