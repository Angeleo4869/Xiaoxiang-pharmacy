package com.xiaoxiang.org.vo;

import com.xiaoxiang.org.dao.BaseHibernateDAO;
import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * OrderView entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.xiaoxiang.org.vo.OrderView
 * @author MyEclipse Persistence Tools
 */
public class OrderViewDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(OrderViewDAO.class);

	public void save(OrderView transientInstance) {
		log.debug("saving OrderView instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(OrderView persistentInstance) {
		log.debug("deleting OrderView instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public OrderView findById(com.xiaoxiang.org.vo.OrderViewId id) {
		log.debug("getting OrderView instance with id: " + id);
		try {
			OrderView instance = (OrderView) getSession().get("com.xiaoxiang.org.vo.OrderView", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(OrderView instance) {
		log.debug("finding OrderView instance by example");
		try {
			List results = getSession().createCriteria("com.xiaoxiang.org.vo.OrderView").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding OrderView instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from OrderView as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all OrderView instances");
		try {
			String queryString = "from OrderView";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public OrderView merge(OrderView detachedInstance) {
		log.debug("merging OrderView instance");
		try {
			OrderView result = (OrderView) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(OrderView instance) {
		log.debug("attaching dirty OrderView instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(OrderView instance) {
		log.debug("attaching clean OrderView instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}