package com.xiaoxiang.org.dao;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xiaoxiang.org.vo.Admin;
import com.xiaoxiang.org.vo.Oder;
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

	public boolean save(ShopGoods transientInstance) {
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

	public boolean delete(ShopGoods persistentInstance) {
		try {
			session=getSession();
			transation = session.beginTransaction();
			persistentInstance = session.get(ShopGoods.class, persistentInstance);
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
	public List search(String keyword){
		List list = null;
		try{
			session=getSession();
			Query query = session.createQuery("from Shop_Goods where Goods in "
					+ " (select idGoods from Goods "
					+ " where GoodCheName like '%?%' or GoodsComName like '%?%' or idMajorFunction in "
					+ " (select idMajorFunction from MajorFunction where "
					+ " GoodsMajorFunctioncol like '%?%' or GoodsClass like '%?%' or GoodsSeries like '%?%'))"
					+ " or Stort in "
					+ " (select idStore from Store where StoreName like '%?%')");
			for(int i=0;i<6;i++){
				query.setParameter(i, keyword);
			}
			list = query.list();
			closeSession();
			return list;
		}catch (Exception e) {
			// TODO: handle exception
			throw e;
		}finally {
			
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

	public boolean attachDirty(ShopGoods instance) {
		try {
			session=getSession();
			transation = session.beginTransaction();
			instance = session.get(ShopGoods.class, instance);
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