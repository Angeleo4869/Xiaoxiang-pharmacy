package com.xiaoxiang.org.dao;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xiaoxiang.org.vo.OrderView;
import com.xiaoxiang.org.vo.Orderdetail;

/**
 * A data access object (DAO) providing persistence and search support for
 * Orderdetail entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.xiaoxiang.org.dao.Orderdetail
 * @author MyEclipse Persistence Tools
 */
//������DAO
public class OrderdetailDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(OrderdetailDAO.class);

	public boolean save(Orderdetail transientInstance) {
		log.debug("saving Orderdetail instance");
		try {
			getSession().save(transientInstance);
			transation.commit();
			log.debug("save successful");
			closeSession();
			return true;
		} catch (Exception re) {
			log.error("save failed", re);
			throw re;
		}finally {
			closeSession();
		}
	}

	public boolean delete(Orderdetail persistentInstance) {
		log.debug("deleting Orderdetail instance");
		try {
			getSession().delete(persistentInstance);
			transation.commit();
			log.debug("delete successful");
			closeSession();
			return true;
		} catch (Exception re) {
			log.error("delete failed", re);
			return false;
		}finally {
			closeSession();
		}
	}

	public Orderdetail findById(java.lang.Integer id) {
		log.debug("getting Orderdetail instance with id: " + id);
		try {
			Orderdetail instance = (Orderdetail) getSession().get(Orderdetail.class, id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}


	public List findByExample(Orderdetail instance) {
		log.debug("finding Orderdetail instance by example");
		try {
			List results = getSession().createCriteria(Orderdetail.class)
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (Exception re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	public List findByOrderView(Integer idbuyer,Short orderstate){
		log.debug("finding Orderdetail_View instance by idbuyer");
		try {
			String queryString = "SELECT * FROM  order_view"
					+ " where idbuyer = ?  and odstate = ? ";
			SQLQuery queryObject = getSession().createSQLQuery(queryString);
			queryObject.setParameter(0, idbuyer);
			queryObject.setParameter(1, orderstate);
			queryObject.addEntity(OrderView.class);
			return queryObject.list();
		} catch (Exception re) {
			log.error("find by idbuyer failed", re);
			throw re;
		}finally {
			closeSession();
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Orderdetail instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Orderdetail as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all Orderdetail instances");
		try {
			String queryString = "from Orderdetail";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Orderdetail merge(Orderdetail detachedInstance) {
		log.debug("merging Orderdetail instance");
		try {
			Orderdetail result = (Orderdetail) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public boolean attachDirty(Orderdetail instance) {
		log.debug("attaching dirty Orderdetail instance");
		try {
			getSession().update(instance);
			transation.commit();
			log.debug("attach successful");
			closeSession();
			return true;
		} catch (Exception re) {
			log.error("attach failed", re);
			return false;
		}finally {
			closeSession();
		}
	}

	public void attachClean(Orderdetail instance) {
		log.debug("attaching clean Orderdetail instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}