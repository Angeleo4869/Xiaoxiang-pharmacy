package com.xiaoxiang.org.dao;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xiaoxiang.org.vo.Admin;
import com.xiaoxiang.org.vo.Oder;
import com.xiaoxiang.org.vo.Shoppingcart;

/**
 * A data access object (DAO) providing persistence and search support for
 * Shoppingcart entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.xiaoxiang.org.dao.Shoppingcart
 * @author MyEclipse Persistence Tools
 */
public class ShoppingcartDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(ShoppingcartDAO.class);
	// property constants
	public static final String GOODS_NUMBER = "goodsNumber";

	public boolean save(Shoppingcart transientInstance) {
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

	public boolean delete(Shoppingcart persistentInstance) {
		try {
			session=getSession();
			transation = session.beginTransaction();
			persistentInstance = session.get(Shoppingcart.class, persistentInstance);
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

	public Shoppingcart findById(java.lang.Integer id) {
		log.debug("getting Shoppingcart instance with id: " + id);
		try {
			Shoppingcart instance = (Shoppingcart) getSession().get("com.xiaoxiang.org.dao.Shoppingcart", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Shoppingcart instance) {
		log.debug("finding Shoppingcart instance by example");
		try {
			List results = getSession().createCriteria("com.xiaoxiang.org.dao.Shoppingcart")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Shoppingcart instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Shoppingcart as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByGoodsNumber(Object goodsNumber) {
		return findByProperty(GOODS_NUMBER, goodsNumber);
	}

	public List findAll() {
		log.debug("finding all Shoppingcart instances");
		try {
			String queryString = "from Shoppingcart";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Shoppingcart merge(Shoppingcart detachedInstance) {
		log.debug("merging Shoppingcart instance");
		try {
			Shoppingcart result = (Shoppingcart) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public boolean attachDirty(Shoppingcart instance) {
		try {
			session=getSession();
			transation = session.beginTransaction();
			instance = session.get(Shoppingcart.class, instance);
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

	public void attachClean(Shoppingcart instance) {
		log.debug("attaching clean Shoppingcart instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}