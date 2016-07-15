package com.kenfor.demo.dao;

import java.util.List;

import com.kenfor.demo.pojo.User;

public interface IUserDAO {
	public void save(User transientInstance);

	public void delete(User persistentInstance);

	public User findById(java.lang.Integer id);

	public List<User> findByExample(User instance);

	public List<User> findByProperty(String propertyName, Object value);

	public List<User> findByUsername(Object username);

	public List<User> findByPassword(Object password);

	public List<User> findByEmail(Object email);

	public List<User> findAll();

	public User merge(User detachedInstance);

	public void attachDirty(User instance);

	public void attachClean(User instance);
}
