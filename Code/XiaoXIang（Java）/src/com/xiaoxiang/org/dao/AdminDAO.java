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
 * A data access object (DAO) providing persistence and search support for Admin
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.xiaoxiang.org.dao.Admin
 * @author MyEclipse Persistence Tools
 */
public class AdminDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(AdminDAO.class);
	// property constants
	public static final String ADMIN_NUMBER = "adminNumber";
	public static final String ADMIN_PASSWORD = "adminPassword";

	public Boolean save(Admin transientInstance) {
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

	public boolean delete(Admin persistentInstance) {
		try {
			session=getSession();
			transation = session.beginTransaction();
			persistentInstance = session.get(Admin.class, persistentInstance);
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

	public Admin findById(java.lang.Integer id) {
		log.debug("getting Admin instance with id: " + id);
		try {
			Admin instance = (Admin) getSession().get(Admin.class, id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Admin instance) {
		log.debug("finding Admin instance by example");
		try {
			List results = getSession().createCriteria(Admin.class).add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Admin instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Admin as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByAdminNumber(Object adminNumber) {
		return findByProperty(ADMIN_NUMBER, adminNumber);
	}

	public List findByAdminPassword(Object adminPassword) {
		return findByProperty(ADMIN_PASSWORD, adminPassword);
	}

	public List findAll() {
		log.debug("finding all Admin instances");
		try {
			String queryString = "from Admin";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Admin merge(Admin detachedInstance) {
		log.debug("merging Admin instance");
		try {
			Admin result = (Admin) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public boolean attachDirty(Admin instance) {
		try {
			session=getSession();
			transation = session.beginTransaction();
			instance = session.get(Admin.class, instance);
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

	public void attachClean(Admin instance) {
		log.debug("attaching clean Admin instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}