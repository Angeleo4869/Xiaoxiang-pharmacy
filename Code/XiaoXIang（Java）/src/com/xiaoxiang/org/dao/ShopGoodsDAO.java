package com.xiaoxiang.org.dao;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xiaoxiang.org.vo.ShopGoods;

/**
 * A data access object (DAO) providing persistence and search support for
 * ShopGoods entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.xiaoxiang.org.dao.ShopGoods
 * @author MyEclipse Persistence Tools
 */
public class ShopGoodsDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(ShopGoodsDAO.class);
	// property constants
	public static final String SHOP_GOODS_IMAGE = "shopGoodsImage";
	public static final String SHOP_GOODS_PRICE = "shopGoodsPrice";
	public static final String SHOP_GOODS_INVENTORY = "shopGoodsInventory";
	public static final String SHOP_GOODS_FREIGHT = "shopGoodsFreight";

	public void save(ShopGoods transientInstance) {
		log.debug("saving ShopGoods instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(ShopGoods persistentInstance) {
		log.debug("deleting ShopGoods instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ShopGoods findById(java.lang.Integer id) {
		log.debug("getting ShopGoods instance with id: " + id);
		try {
			ShopGoods instance = (ShopGoods) getSession().get("com.xiaoxiang.org.dao.ShopGoods", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(ShopGoods instance) {
		log.debug("finding ShopGoods instance by example");
		try {
			List results = getSession().createCriteria("com.xiaoxiang.org.dao.ShopGoods").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding ShopGoods instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from ShopGoods as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByShopGoodsImage(Object shopGoodsImage) {
		return findByProperty(SHOP_GOODS_IMAGE, shopGoodsImage);
	}

	public List findByShopGoodsPrice(Object shopGoodsPrice) {
		return findByProperty(SHOP_GOODS_PRICE, shopGoodsPrice);
	}

	public List findByShopGoodsInventory(Object shopGoodsInventory) {
		return findByProperty(SHOP_GOODS_INVENTORY, shopGoodsInventory);
	}

	public List findByShopGoodsFreight(Object shopGoodsFreight) {
		return findByProperty(SHOP_GOODS_FREIGHT, shopGoodsFreight);
	}

	public List findAll() {
		log.debug("finding all ShopGoods instances");
		try {
			String queryString = "from ShopGoods";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public ShopGoods merge(ShopGoods detachedInstance) {
		log.debug("merging ShopGoods instance");
		try {
			ShopGoods result = (ShopGoods) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ShopGoods instance) {
		log.debug("attaching dirty ShopGoods instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ShopGoods instance) {
		log.debug("attaching clean ShopGoods instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}