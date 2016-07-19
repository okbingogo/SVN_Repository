package com.kenfor.ssm.service.impl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kenfor.ssm.base.MyException;
import com.kenfor.ssm.dao.IUserDAO;
import com.kenfor.ssm.model.User;
import com.kenfor.ssm.service.IUserService;

@Service
public class UserService implements IUserService {

	private static final Logger log = Logger.getLogger(UserService.class);
	@Resource
	private IUserDAO userDAO;

	public UserService() { }

	@Override
	public void login(String username, String password) throws MyException {
		log.info("进行用户登录：username==>" + username + ",password==>" + password);
		User user = userDAO.selectByUsername(username);
		if (user != null && user.getPassword().equals(password)) {
			return;
		}
		throw new MyException("登录失败，用户名或者密码错误！");
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean register(String username, String password, String email)
			throws MyException {
		log.info("进行用户注册：username==>" + username + ",password==>" + password
				+ ",email==>" + email);
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		try {
			if (userDAO.insert(user) == 1) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public User findUserByUsername(String username) throws MyException {
		log.info("查找用户名为：" + username + " 的用户......");
		try {
			return userDAO.selectByUsername(username);
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException("获取用户失败，请重试！");
		}
	}
	
	public boolean checkUsername(String username) {
		return userDAO.selectByUsername(username) == null;
	}

	public boolean checkEmail(String email) {
		System.out.println(email);
		return userDAO.selectByEmail(email) == null;
	}

}
