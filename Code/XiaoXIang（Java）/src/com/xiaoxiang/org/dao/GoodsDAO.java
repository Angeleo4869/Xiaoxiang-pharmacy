package com.xiaoxiang.org.dao;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xiaoxiang.org.vo.Goods;
import com.xiaoxiang.org.vo.GoodsDetailView;

/**
 * A data access object (DAO) providing persistence and search support for Goods
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.xiaoxiang.org.dao.Goods
 * @author MyEclipse Persistence Tools
 */
public class GoodsDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(GoodsDAO.class);

	public boolean save(Goods transientInstance) {
		log.debug("saving Goods instance");
		try {
			getSession().save(transientInstance);
			transation.commit();
			log.debug("save successful");
			closeSession();
			return true;
		} catch (Exception re) {
			log.error("save failed", re);
			return false;
		}
	}

	public boolean delete(Goods persistentInstance) {
		log.debug("deleting Goods instance");
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

	public Goods findById(java.lang.Integer id) {
		log.debug("getting Goods instance with id: " + id);
		try {
			Goods instance = (Goods) getSession().get(Goods.class, id);
			closeSession();
			return instance;
		} catch (Exception re) {
			log.error("get failed", re);
			throw re;
		}finally {
			closeSession();
		}
	}
	
	public List  findGoodsDeatil(java.lang.Integer id) {
		log.debug("getting Goods instance with id: " + id);
		try {
			String queryString = "select * from GoodsDetail_view where idShop_Goods = ? ";
			SQLQuery queryObject = getSession().createSQLQuery(queryString);
			queryObject.setParameter(0, id);
			queryObject.addEntity(GoodsDetailView.class);
			return queryObject.list();
		} catch (Exception re) {
			log.error("find all failed", re);
			throw re;
		}finally {
			closeSession();
		}
	}

	public List findByExample(Goods instance) {
		log.debug("finding Goods instance by example");
		try {
			List results = getSession().createCriteria(Goods.class)
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (Exception re) {
			log.error("find by example failed", re);
			throw re;
		}finally {
			closeSession();
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Goods instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Goods as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all Goods instances");
		try {
			String queryString = "from Goods";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}finally {
			closeSession();
		}
	}

	public Goods merge(Goods detachedInstance) {
		log.debug("merging Goods instance");
		try {
			Goods result = (Goods) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public boolean attachDirty(Goods instance) {
		log.debug("attaching dirty Goods instance");
		try {
			getSession().saveOrUpdate(instance);
			transation.commit();
			log.debug("attach successful");
			return true;
		} catch (Exception re) {
			log.error("attach failed", re);
			throw re;
		}finally {
			closeSession();
		}
	}

	public void attachClean(Goods instance) {
		log.debug("attaching clean Goods instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}