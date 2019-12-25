package com.xiaoxiang.org.dao;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xiaoxiang.org.vo.Buyer;
import com.xiaoxiang.org.vo.GoodsView;
import com.xiaoxiang.org.vo.ShopGoods;

/**
 * A data access object (DAO) providing persistence and search support for
 * ShopGoods entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.xiaoxiang.org.dao.ShopGoodsTest
 * @author MyEclipse Persistence Tools
 */
public class ShopGoodsDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(ShopGoodsDAO.class);

	public boolean save(ShopGoods transientInstance) {
		log.debug("saving ShopGoods instance");
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

	public boolean delete(ShopGoods persistentInstance) {
		log.debug("deleting ShopGoods instance");
		try {
			getSession().delete(persistentInstance);
			transation.commit();
			log.debug("delete successful");
			return true;
		} catch (Exception re) {
			log.error("delete failed", re);
			throw re;
		}finally {
			closeSession();
		}
	}

	public ShopGoods findById(java.lang.Integer id) {
		log.debug("getting ShopGoods instance with id: " + id);
		try {
			ShopGoods instance = (ShopGoods) getSession().get(ShopGoods.class, id);
			return instance;
		} catch (Exception re) {
			log.error("get failed", re);
			throw re;
		}finally {
			closeSession();
		}
	}

	public List findByExample(ShopGoods instance) {
		log.debug("finding ShopGoods instance by example");
		try {
			List results = getSession().createCriteria(ShopGoods.class).add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (Exception re) {
			log.error("find by example failed", re);
			return null;
		}finally {
			closeSession();
		}
	}
	public List search(String keyword){
		log.debug("finding ShopGoods instance by keyword");
		try{
			session=getSession();
			SQLQuery  query = session.createSQLQuery("{call searchByKeyWord( ? )}");
			query.setParameter(0, keyword);
			query.addEntity("bv",GoodsView.class);
			List list = query.list();
			closeSession();
			return list;
		}catch (Exception e) {
			// TODO: handle exception
			throw e;
		}finally {
			closeSession();
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
		}finally {
			closeSession();
		}
	}

	public List findAll() {
		log.debug("finding all ShopGoods instances");
		try {
			String queryString = "from ShopGoods";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (Exception re) {
			log.error("find all failed", re);
			return null;
		}finally {
			closeSession();
		}
	}
	public List touristsRecommendedGoods(){
		log.debug("recommended Goods instances");
		try {
			String queryString = "from GoodsView";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (Exception re) {
			log.error("find all failed", re);
			return null;
		}finally {
			closeSession();
		}
	}
	
	public GoodsView findGoodsByIdShopGoods(ShopGoods id ){
		log.debug("recommended Goods instances");
		try { 
			String queryString = "select * from Goods_view where idShop_Goods = ?";
			SQLQuery queryObject = getSession().createSQLQuery(queryString);
			queryObject.setParameter(0, id.getIdShopGoods());
			queryObject.addEntity(GoodsView.class);
			return (GoodsView)queryObject.list().get(0);
		} catch (Exception re) {
			log.error("find all failed", re);
			return null;
		}finally {
			closeSession();
		}
	}
	
	public List membersRecommendedGoods(Buyer buyer){
		log.debug("recommended Goods instances");
		try {
			String queryString = "select * from Goods_view"
					+ " where Goods_view.idShop_Goods in ("
					+ " select od.idShop_Goods"
					+ " from orderdetail as od"
					+ " where od.idBuyer = ?)";
			SQLQuery queryObject = getSession().createSQLQuery(queryString);
			queryObject.addEntity(GoodsView.class);
			queryObject.setParameter(0, buyer);
			return queryObject.list();
		} catch (Exception re) {
			log.error("find all failed", re);
			re.printStackTrace();
			return null;
		}finally {
			closeSession();
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
		}finally {
			closeSession();
		}
	}

	public boolean attachDirty(ShopGoods instance) {
		log.debug("attaching dirty ShopGoods instance");
		try {
			getSession().saveOrUpdate(instance);
			transation.commit();
			log.debug("attach successful");
			return true;
		} catch (RuntimeException re) {
			log.error("attach failed", re);
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
		}finally {
			closeSession();
		}
	}
}