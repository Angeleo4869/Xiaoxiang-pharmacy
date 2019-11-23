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
	// property constants
	public static final String STORE_NUMBER = "storeNumber";
	public static final String STORE_PASSWORD = "storePassword";
	public static final String STORE_NAME = "storeName";
	public static final String STORE_STATE = "storeState";
	public static final String STORE_PHY_NAME = "storePhyName";
	public static final String STORE_PHY_ID_CARD = "storePhyIdCard";
	public static final String STORE_LICENSE = "storeLicense";
	public static final String STORE_TEL = "storeTel";
	public static final String STORE_ADDRESS = "storeAddress";

	public void save(Store transientInstance) {
		log.debug("saving Store instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Store persistentInstance) {
		log.debug("deleting Store instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Store findById(java.lang.Integer id) {
		log.debug("getting Store instance with id: " + id);
		try {
			Store instance = (Store) getSession().get("com.xiaoxiang.org.dao.Store", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Store instance) {
		log.debug("finding Store instance by example");
		try {
			List results = getSession().createCriteria("com.xiaoxiang.org.dao.Store").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Store instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Store as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByStoreNumber(Object storeNumber) {
		return findByProperty(STORE_NUMBER, storeNumber);
	}

	public List findByStorePassword(Object storePassword) {
		return findByProperty(STORE_PASSWORD, storePassword);
	}

	public List findByStoreName(Object storeName) {
		return findByProperty(STORE_NAME, storeName);
	}

	public List findByStoreState(Object storeState) {
		return findByProperty(STORE_STATE, storeState);
	}

	public List findByStorePhyName(Object storePhyName) {
		return findByProperty(STORE_PHY_NAME, storePhyName);
	}

	public List findByStorePhyIdCard(Object storePhyIdCard) {
		return findByProperty(STORE_PHY_ID_CARD, storePhyIdCard);
	}

	public List findByStoreLicense(Object storeLicense) {
		return findByProperty(STORE_LICENSE, storeLicense);
	}

	public List findByStoreTel(Object storeTel) {
		return findByProperty(STORE_TEL, storeTel);
	}

	public List findByStoreAddress(Object storeAddress) {
		return findByProperty(STORE_ADDRESS, storeAddress);
	}

	public List findAll() {
		log.debug("finding all Store instances");
		try {
			String queryString = "from Store";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Store merge(Store detachedInstance) {
		log.debug("merging Store instance");
		try {
			Store result = (Store) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Store instance) {
		log.debug("attaching dirty Store instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
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