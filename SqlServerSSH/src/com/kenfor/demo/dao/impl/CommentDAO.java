package com.kenfor.demo.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Component;

import com.kenfor.demo.base.BaseDaoSupport;
import com.kenfor.demo.dao.ICommentDAO;
import com.kenfor.demo.pojo.Comment;

/**
 * A data access object (DAO) providing persistence and search support for
 * Comment entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.kenfor.demo.pojo.Comment
 * @author MyEclipse Persistence Tools
 */
@Component
public class CommentDAO extends BaseDaoSupport implements ICommentDAO {
	private static final Logger log = LoggerFactory.getLogger(CommentDAO.class);
	// property constants
	public static final String FROM_NAME = "fromName";
	public static final String MSG_ID = "msgId";
	public static final String COMM_CONTENT = "commContent";
	
	public static String lastHQL = "";

	protected void initDao() {
		// do nothing
	}

	public void save(Comment transientInstance) {
		log.debug("saving Comment instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Comment persistentInstance) {
		log.debug("deleting Comment instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Comment findById(java.lang.Integer id) {
		log.debug("getting Comment instance with id: " + id);
		try {
			Comment instance = (Comment) getHibernateTemplate().get(
					"com.kenfor.demo.pojo.Comment", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Comment> findByExample(Comment instance) {
		log.debug("finding Comment instance by example");
		try {
			List<Comment> results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List<Comment> findByProperty(String propertyName, Object value) {
		log.debug("finding Comment instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Comment as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Comment> findByFromName(Object fromName) {
		return findByProperty(FROM_NAME, fromName);
	}

	public List<Comment> findByMsgId(Object msgId) {
		return findByProperty(MSG_ID, msgId);
	}

	public List<Comment> findByCommContent(Object commContent) {
		return findByProperty(COMM_CONTENT, commContent);
	}

	public List<Comment> findAll() {
		log.debug("finding all Comment instances");
		try {
			String queryString = "from Comment";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Comment merge(Comment detachedInstance) {
		log.debug("merging Comment instance");
		try {
			Comment result = (Comment) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Comment instance) {
		log.debug("attaching dirty Comment instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Comment instance) {
		log.debug("attaching clean Comment instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CommentDAO getFromApplicationContext(ApplicationContext ctx) {
		return (CommentDAO) ctx.getBean("CommentDAO");
	}

	@Override
	public List<Comment> queryForPage(Integer msgId, final Integer curPage,
			final Integer length, String keyword, String startTime, String endTime) {
		StringBuilder sb = new StringBuilder("from Comment where 1=1");
		if(msgId!=null){
			sb.append(" and msg_id = ").append(msgId);
		}else{
			return null;
		}
		if (keyword != null && !"".equals(keyword)) {
			sb.append(" and (comm_content like '%").append(keyword).append("%' or from_name like '%").append(keyword).append("%')");
		}
		if (startTime != null && !"".equals(startTime)) {
			sb.append(" and comm_time >= '").append(startTime).append("'");
		}
		if (endTime != null && !"".equals(endTime)) {
			sb.append(" and comm_time <= '").append(endTime).append("'");
		}
		sb.append(" order by comm_time desc");
		final String hql = sb.toString();
		// List list = findAll();
		List<Comment> list = getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				query.setFirstResult(curPage * length);
				query.setMaxResults(length);
				List<Comment> list = query.list();
				return list;
			}
		});
		lastHQL = hql;
		return list;
	}

	@Override
	public Long getAllRowCount() {
		Long count = 0L;
		if (lastHQL != null && !"".equals(lastHQL)) {
			String totalHql = lastHQL.substring( lastHQL.toLowerCase().indexOf("from"), lastHQL.toLowerCase().indexOf("order")); 
			totalHql = "SELECT COUNT(*) "+totalHql;
			List list = getHibernateTemplate().find(totalHql);
			count = (Long) list.get(0);
		}
		lastHQL = null;
		return count;
	}
}