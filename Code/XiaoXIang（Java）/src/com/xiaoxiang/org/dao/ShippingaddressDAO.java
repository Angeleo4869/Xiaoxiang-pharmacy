package com.xiaoxiang.org.dao;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xiaoxiang.org.vo.Majorfunction;
import com.xiaoxiang.org.vo.Shippingaddress;

/**
 * A data access object (DAO) providing persistence and search support for
 * Shippingaddress entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.xiaoxiang.org.dao.Shippingaddress
 * @author MyEclipse Persistence Tools
 */
public class ShippingaddressDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(ShippingaddressDAO.class);

	public boolean save(Shippingaddress transientInstance) {
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

	public boolean delete(Shippingaddress persistentInstance) {
		try {
			session=getSession();
			transation = session.beginTransaction();
			persistentInstance = session.get(Shippingaddress.class, persistentInstance);
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

	public Shippingaddress findById(java.lang.Integer id) {
		log.debug("getting Shippingaddress instance with id: " + id);
		try {
			Shippingaddress instance = (Shippingaddress) getSession().get(Shippingaddress.class, id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Shippingaddress instance) {
		log.debug("finding Shippingaddress instance by example");
		try {
			List results = getSession().createCriteria(Shippingaddress.class)
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Shippingaddress instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Shippingaddress as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all Shippingaddress instances");
		try {
			String queryString = "from Shippingaddress";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Shippingaddress merge(Shippingaddress detachedInstance) {
		log.debug("merging Shippingaddress instance");
		try {
			Shippingaddress result = (Shippingaddress) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public boolean attachDirty(Shippingaddress instance) {
		try {
			session=getSession();
			transation = session.beginTransaction();
			instance = session.get(Shippingaddress.class, instance);
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

	public void attachClean(Shippingaddress instance) {
		log.debug("attaching clean Shippingaddress instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}