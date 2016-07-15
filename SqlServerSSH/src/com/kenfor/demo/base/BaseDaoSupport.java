package com.kenfor.demo.base;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class BaseDaoSupport extends HibernateDaoSupport {
	
	@Resource(name="sessionFactory")
	public void setSessionFactoryOverride(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}

}
