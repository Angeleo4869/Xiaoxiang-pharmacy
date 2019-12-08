package com.xiaoxiang.org.dao;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xiaoxiang.org.vo.Majorfunction;

/**
 * A data access object (DAO) providing persistence and search support for
 * Majorfunction entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.xiaoxiang.org.dao.Majorfunction
 * @author MyEclipse Persistence Tools
 */
public class MajorfunctionDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(MajorfunctionDAO.class);

	public void save(Majorfunction transientInstance) {
		log.debug("saving Majorfunction instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Majorfunction persistentInstance) {
		log.debug("deleting Majorfunction instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Majorfunction findById(java.lang.Integer id) {
		log.debug("getting Majorfunction instance with id: " + id);
		try {
			Majorfunction instance = (Majorfunction) getSession().get("com.xiaoxiang.org.dao.Majorfunction", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Majorfunction instance) {
		log.debug("finding Majorfunction instance by example");
		try {
			List results = getSession().createCriteria("com.xiaoxiang.org.dao.Majorfunction")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Majorfunction instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Majorfunction as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all Majorfunction instances");
		try {
			String queryString = "from Majorfunction";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Majorfunction merge(Majorfunction detachedInstance) {
		log.debug("merging Majorfunction instance");
		try {
			Majorfunction result = (Majorfunction) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Majorfunction instance) {
		log.debug("attaching dirty Majorfunction instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Majorfunction instance) {
		log.debug("attaching clean Majorfunction instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}