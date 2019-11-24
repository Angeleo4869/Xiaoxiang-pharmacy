package com.xiaoxiang.org.dao;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xiaoxiang.org.vo.Admin;
import com.xiaoxiang.org.vo.Goods;

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
	// property constants
	public static final String GOODS_NUMBER = "goodsNumber";
	public static final String GOODS_COM_NAME = "goodsComName";
	public static final String GOODS_CHE_NAME = "goodsCheName";
	public static final String GOODS_COMPOSITION = "goodsComposition";
	public static final String GOODS_CHARACTER = "goodsCharacter";
	public static final String STORE_PURCHASE_PRICE = "storePurchasePrice";
	public static final String GOODS_SPECIFICATIONS = "goodsSpecifications";
	public static final String GOODS_USAGE = "goodsUsage";
	public static final String GOODS_TABOO = "goodsTaboo";
	public static final String GOODS_VALIDITY = "goodsValidity";
	public static final String GOODS_MANUFACTURER = "goodsManufacturer";

	public boolean save(Goods transientInstance) {
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

	public boolean delete(Goods persistentInstance) {
		try {
			session=getSession();
			transation = session.beginTransaction();
			persistentInstance = session.get(Goods.class, persistentInstance);
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

	public Goods findById(java.lang.Integer id) {
		log.debug("getting Goods instance with id: " + id);
		try {
			Goods instance = (Goods) getSession().get("com.xiaoxiang.org.dao.Goods", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Goods instance) {
		log.debug("finding Goods instance by example");
		try {
			List results = getSession().createCriteria("com.xiaoxiang.org.dao.Goods").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
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

	public List findByGoodsNumber(Object goodsNumber) {
		return findByProperty(GOODS_NUMBER, goodsNumber);
	}

	public List findByGoodsComName(Object goodsComName) {
		return findByProperty(GOODS_COM_NAME, goodsComName);
	}

	public List findByGoodsCheName(Object goodsCheName) {
		return findByProperty(GOODS_CHE_NAME, goodsCheName);
	}

	public List findByGoodsComposition(Object goodsComposition) {
		return findByProperty(GOODS_COMPOSITION, goodsComposition);
	}

	public List findByGoodsCharacter(Object goodsCharacter) {
		return findByProperty(GOODS_CHARACTER, goodsCharacter);
	}

	public List findByStorePurchasePrice(Object storePurchasePrice) {
		return findByProperty(STORE_PURCHASE_PRICE, storePurchasePrice);
	}

	public List findByGoodsSpecifications(Object goodsSpecifications) {
		return findByProperty(GOODS_SPECIFICATIONS, goodsSpecifications);
	}

	public List findByGoodsUsage(Object goodsUsage) {
		return findByProperty(GOODS_USAGE, goodsUsage);
	}

	public List findByGoodsTaboo(Object goodsTaboo) {
		return findByProperty(GOODS_TABOO, goodsTaboo);
	}

	public List findByGoodsValidity(Object goodsValidity) {
		return findByProperty(GOODS_VALIDITY, goodsValidity);
	}

	public List findByGoodsManufacturer(Object goodsManufacturer) {
		return findByProperty(GOODS_MANUFACTURER, goodsManufacturer);
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
		try {
			session=getSession();
			transation = session.beginTransaction();
			instance = session.get(Goods.class, instance);
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