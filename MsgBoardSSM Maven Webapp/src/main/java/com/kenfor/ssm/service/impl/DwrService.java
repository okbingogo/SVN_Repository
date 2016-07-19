package com.kenfor.ssm.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kenfor.ssm.dao.IUserDAO;

@Service

public class DwrService {
	@Resource
	private IUserDAO userDAO;

	public boolean checkUsername(String username) {
		return userDAO.selectByUsername(username) == null;
	}

	public boolean checkEmail(String email) {
		return userDAO.selectByEmail(email) == null;
	}
}
