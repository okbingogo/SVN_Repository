package com.kenfor.demo.dao;

import java.util.List;

import com.kenfor.demo.pojo.Message;

public interface IMessageDAO {
	public void save(Message transientInstance);

	public void delete(Message persistentInstance);

	public Message findById(java.lang.Integer id);

	public List<Message> findByExample(Message instance);
	
	public List<Message> findByProperty(String propertyName, Object value);

	public List<Message> findByFromName(Object fromName);

	public List<Message> findByMsgContent(Object msgContent);

	public List<Message> findAll();

	public Message merge(Message detachedInstance);

	public void attachDirty(Message instance);

	public void attachClean(Message instance);

	public List<Message> queryForPage(Integer curPage, Integer length,
			String keyword, String startTime, String endTime);

	public Long getAllRowCount();

}
