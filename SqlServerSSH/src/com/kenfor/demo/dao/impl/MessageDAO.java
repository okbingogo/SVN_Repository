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
import com.kenfor.demo.dao.IMessageDAO;
import com.kenfor.demo.pojo.Message;

/**
 * A data access object (DAO) providing persistence and search support for
 * Message entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.kenfor.demo.pojo.Message
 * @author MyEclipse Persistence Tools
 */
@Component
public class MessageDAO extends BaseDaoSupport implements IMessageDAO {
	private static final Logger log = LoggerFactory.getLogger(MessageDAO.class);
	// property constants
	public static final String FROM_NAME = "fromName";
	public static final String MSG_CONTENT = "msgContent";
	
	public static String lastHQL = "";

	protected void initDao() {
		// do nothing
	}

	public void save(Message transientInstance) {
		log.debug("saving Message instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Message persistentInstance) {
		log.debug("deleting Message instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Message findById(java.lang.Integer id) {
		log.debug("getting Message instance with id: " + id);
		try {
			Message instance = (Message) getHibernateTemplate().get(
					"com.kenfor.demo.pojo.Message", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Message> findByExample(Message instance) {
		log.debug("finding Message instance by example");
		try {
			List<Message> results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List<Message> findByProperty(String propertyName, Object value) {
		log.debug("finding Message instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Message as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Message> findByFromName(Object fromName) {
		return findByProperty(FROM_NAME, fromName);
	}

	public List<Message> findByMsgContent(Object msgContent) {
		return findByProperty(MSG_CONTENT, msgContent);
	}

	public List<Message> findAll() {
		log.debug("finding all Message instances");
		try {
			String queryString = "from Message";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Message merge(Message detachedInstance) {
		log.debug("merging Message instance");
		try {
			Message result = (Message) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Message instance) {
		log.debug("attaching dirty Message instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Message instance) {
		log.debug("attaching clean Message instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static MessageDAO getFromApplicationContext(ApplicationContext ctx) {
		return (MessageDAO) ctx.getBean("MessageDAO");
	}

	@Override
	public List<Message> queryForPage(final Integer curPage, final Integer length,
			String keyword, String startTime, String endTime) {
		StringBuilder sb = new StringBuilder("from Message where 1=1");
		if (keyword != null && !"".equals(keyword)) {
			sb.append(" and (msg_content like '%").append(keyword).append("%' or from_name like '%").append(keyword).append("%')");
		}
		if (startTime != null && !"".equals(startTime)) {
			sb.append(" and msg_time >= '").append(startTime).append("'");
		}
		if (endTime != null && !"".equals(endTime)) {
			sb.append(" and msg_time <= '").append(endTime).append("'");
		}
		sb.append(" order by msg_time desc");
		final String hql = sb.toString();
		List<Message> list = getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				query.setFirstResult(curPage * length);
				query.setMaxResults(length);
				List<Message> list = query.list();
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