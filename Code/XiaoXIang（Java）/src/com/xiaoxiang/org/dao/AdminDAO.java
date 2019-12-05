package com.xiaoxiang.org.dao;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.xiaoxiang.org.vo.Admin;

/**
 * A data access object (DAO) providing persistence and search support for Admin
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.xiaoxiang.org.dao.Admin
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class AdminDAO extends BaseDAO{
	private static final Logger log = LoggerFactory.getLogger(AdminDAO.class);

	public Boolean save(Admin transientInstance) {
		try {
			session=getSession();
			transaction = session.beginTransaction();
			session.save(transientInstance);
			transaction.commit();
			closeSession();
			return true;
		} catch (Exception re) {
			re.printStackTrace();;
			return false;
		}finally {
			closeSession();
		}
	}

	public boolean delete(Admin persistentInstance) {
		try {
			session=getSession();
			transaction = session.beginTransaction();
			persistentInstance = (Admin) session.get(Admin.class, persistentInstance);
			session.delete(persistentInstance);
			transaction.commit();
			closeSession();
			return true;
		} catch (Exception re) {
			re.printStackTrace();
			return false;
		}finally {
			closeSession();
		}
	}

	public Admin findById(java.lang.Integer id) {
		try {
			session=getSession();
			transaction = session.beginTransaction();
			Admin admin = (Admin) session.get(Admin.class, id);
			closeSession();
			return admin;
		} catch (Exception re) {
			log.error("get failed", re);
			return null;
		}finally {
			closeSession();
		}
	}

	public List findByExample(Admin instance) {
		log.debug("finding Admin instance by example");
		try {
			session=getSession();
			transaction = session.beginTransaction();
			List results = session.createCriteria(Admin.class)
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			closeSession();
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			return null;
		}finally {
			closeSession();
		}
	}

//	public List findByProperty(String propertyName, Object value) {
//		log.debug("finding Admin instance with property: " + propertyName + ", value: " + value);
//		try {
//			String queryString = "from Admin as model where model." + propertyName + "= ?";
//			Query queryObject = getCurrentSession().createQuery(queryString);
//			queryObject.setParameter(0, value);
//			return queryObject.list();
//		} catch (RuntimeException re) {
//			log.error("find by property name failed", re);
//			throw re;
//		}
//	}
//
//	public List findAll() {
//		log.debug("finding all Admin instances");
//		try {
//			String queryString = "from Admin";
//			Query queryObject = getCurrentSession().createQuery(queryString);
//			return queryObject.list();
//		} catch (RuntimeException re) {
//			log.error("find all failed", re);
//			throw re;
//		}
//	}
//
//	public Admin merge(Admin detachedInstance) {
//		log.debug("merging Admin instance");
//		try {
//			Admin result = (Admin) getCurrentSession().merge(detachedInstance);
//			log.debug("merge successful");
//			return result;
//		} catch (RuntimeException re) {
//			log.error("merge failed", re);
//			throw re;
//		}
//	}
//
//	public void attachDirty(Admin instance) {
//		log.debug("attaching dirty Admin instance");
//		try {
//			getCurrentSession().saveOrUpdate(instance);
//			log.debug("attach successful");
//		} catch (RuntimeException re) {
//			log.error("attach failed", re);
//			throw re;
//		}
//	}
//
//	public void attachClean(Admin instance) {
//		log.debug("attaching clean Admin instance");
//		try {
//			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(instance);
//			log.debug("attach successful");
//		} catch (RuntimeException re) {
//			log.error("attach failed", re);
//			throw re;
//		}
//	}

	public static AdminDAO getFromApplicationContext(ApplicationContext ctx) {
		return (AdminDAO) ctx.getBean("AdminDAO");
	}
}