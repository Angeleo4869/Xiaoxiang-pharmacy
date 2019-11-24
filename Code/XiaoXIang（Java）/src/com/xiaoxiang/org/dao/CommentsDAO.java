package com.xiaoxiang.org.dao;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xiaoxiang.org.vo.Admin;
import com.xiaoxiang.org.vo.Comments;

/**
 * A data access object (DAO) providing persistence and search support for
 * Comments entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.xiaoxiang.org.dao.Comments
 * @author MyEclipse Persistence Tools
 */
public class CommentsDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(CommentsDAO.class);
	// property constants
	public static final String COMMENT_LEVEL = "commentLevel";
	public static final String COMMENTS_ANONYMOUS = "commentsAnonymous";
	public static final String COMMENTSDETAILS = "commentsdetails";
	public static final String COMMENTS_REPLYID = "commentsReplyid";

	public boolean save(Comments transientInstance) {
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

	public boolean delete(Comments persistentInstance) {
		try {
			session=getSession();
			transation = session.beginTransaction();
			persistentInstance = session.get(Comments.class, persistentInstance);
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

	public Comments findById(java.lang.Integer id) {
		log.debug("getting Comments instance with id: " + id);
		try {
			Comments instance = (Comments) getSession().get("com.xiaoxiang.org.dao.Comments", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Comments instance) {
		log.debug("finding Comments instance by example");
		try {
			List results = getSession().createCriteria("com.xiaoxiang.org.dao.Comments").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Comments instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Comments as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByCommentLevel(Object commentLevel) {
		return findByProperty(COMMENT_LEVEL, commentLevel);
	}

	public List findByCommentsAnonymous(Object commentsAnonymous) {
		return findByProperty(COMMENTS_ANONYMOUS, commentsAnonymous);
	}

	public List findByCommentsdetails(Object commentsdetails) {
		return findByProperty(COMMENTSDETAILS, commentsdetails);
	}

	public List findByCommentsReplyid(Object commentsReplyid) {
		return findByProperty(COMMENTS_REPLYID, commentsReplyid);
	}

	public List findAll() {
		log.debug("finding all Comments instances");
		try {
			String queryString = "from Comments";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Comments merge(Comments detachedInstance) {
		log.debug("merging Comments instance");
		try {
			Comments result = (Comments) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public boolean attachDirty(Comments instance) {
		try {
			session=getSession();
			transation = session.beginTransaction();
			instance = session.get(Comments.class, instance);
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

	public void attachClean(Comments instance) {
		log.debug("attaching clean Comments instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}