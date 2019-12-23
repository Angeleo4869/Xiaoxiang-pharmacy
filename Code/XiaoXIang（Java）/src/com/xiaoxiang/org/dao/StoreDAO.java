package com.xiaoxiang.org.dao;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xiaoxiang.org.vo.Store;

/**
 * A data access object (DAO) providing persistence and search support for Store
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.xiaoxiang.org.dao.Store
 * @author MyEclipse Persistence Tools
 */
public class StoreDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(StoreDAO.class);

	public boolean save(Store transientInstance) {
		log.debug("saving Store instance");
		try {
			getSession().save(transientInstance);
			transation.commit();
			log.debug("save successful");
			closeSession();
			return true;
		} catch (Exception re) {
			log.error("save failed", re);
			return false;
		}finally {
			closeSession();
		}
	}

	public void delete(Store persistentInstance) {
		log.debug("deleting Store instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
			closeSession();
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}finally {
			closeSession();
		}
	}

	public Store findById(java.lang.Integer id) {
		log.debug("getting Store instance with id: " + id);
		try {
			Store instance = (Store) getSession().get(Store.class, id);
			closeSession();
			return instance;
		} catch (Exception re) {
			log.error("get failed", re);
			throw re;
		}finally {
			closeSession();
		}
	}

	public List findByExample(Store instance) {
		log.debug("finding Store instance by example");
		try {
			List results = getSession().createCriteria(Store.class)
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			closeSession();
			return results;
		} catch (Exception re) {
			log.error("find by example failed", re);
			throw re;
		}finally {
			closeSession();
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Store instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Store as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			closeSession();
			return queryObject.list();
		} catch (Exception re) {
			log.error("find by property name failed", re);
			throw re;
		}finally {
			closeSession();
		}
	}

	public List findAll() {
		log.debug("finding all Store instances");
		try {
			String queryString = "from Store";
			Query queryObject = getSession().createQuery(queryString);
			closeSession();
			return queryObject.list();
		} catch (Exception re) {
			log.error("find all failed", re);
			throw re;
		}finally {
			closeSession();
		}
	}

	public Store merge(Store detachedInstance) {
		log.debug("merging Store instance");
		try {
			Store result = (Store) getSession().merge(detachedInstance);
			log.debug("merge successful");
			closeSession();
			return result;
		} catch (Exception re) {
			log.error("merge failed", re);
			throw re;
		}finally {
			closeSession();
		}
	}

	public void attachDirty(Store instance) {
		log.debug("attaching dirty Store instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (Exception re) {
			log.error("attach failed", re);
			throw re;
		}finally {
			closeSession();
		}
	}

	public void attachClean(Store instance) {
		log.debug("attaching clean Store instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}