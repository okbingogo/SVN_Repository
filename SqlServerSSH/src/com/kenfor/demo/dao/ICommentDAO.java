package com.kenfor.demo.dao;

import java.util.List;

import com.kenfor.demo.pojo.Comment;

public interface ICommentDAO {

	public void save(Comment transientInstance);

	public void delete(Comment persistentInstance);

	public Comment findById(java.lang.Integer id);

	public List<Comment> findByExample(Comment instance);

	public List<Comment> findByProperty(String propertyName, Object value);

	public List<Comment> findByFromName(Object fromName);

	public List<Comment> findByMsgId(Object msgId);

	public List<Comment> findByCommContent(Object commContent);

	public List<Comment> findAll();

	public Comment merge(Comment detachedInstance);

	public void attachDirty(Comment instance);

	public void attachClean(Comment instance);

	public List<Comment> queryForPage(Integer msgId, Integer curPage,
			Integer length, String keyword, String startTime, String endTime);

	public Long getAllRowCount();
}
