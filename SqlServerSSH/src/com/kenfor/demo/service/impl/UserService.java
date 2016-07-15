package com.kenfor.demo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.kenfor.demo.base.MyException;
import com.kenfor.demo.dao.IUserDAO;
import com.kenfor.demo.pojo.User;
import com.kenfor.demo.service.IUserService;

@Service
public class UserService implements IUserService {
	@Resource
	private IUserDAO userDAO;

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public void login(String username, String password) throws Exception {
		List<User> userList = userDAO.findByUsername(username);
		if((userList.isEmpty()) ? false : userList.get(0).getPassword()
				.equals(password)){
			return;
		}else{
			throw new MyException("登录失败！");
		}
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void register(String username, String password, String email)
			throws Exception {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		try {
			userDAO.save(user);
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException("注册失败");
		}
	}

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<User> getUserList() throws Exception {
		return userDAO.findAll();
	}

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public User findUserByUsername(String username) throws Exception {
		return (User) userDAO.findByUsername("%" + username + "%");
	}

}
