package com.xiaoxiang.org.dao;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xiaoxiang.org.vo.GoodsDetailView;

/**
 * A data access object (DAO) providing persistence and search support for
 * GoodsDetailView entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.xiaoxiang.org.dao.GoodsDetailView
 * @author MyEclipse Persistence Tools
 */
public class GoodsDetailViewDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(GoodsDetailViewDAO.class);

	public List findByExample(GoodsDetailView instance) {
		log.debug("finding GoodsDetailView instance by example");
		try {
			List results = getSession().createCriteria(GoodsDetailView.class)
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

	public List findAll() {
		log.debug("finding all GoodsDetailView instances");
		try {
			String queryString = "from GoodsDetailView";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (Exception re) {
			log.error("find all failed", re);
			throw re;
		}
	}

}