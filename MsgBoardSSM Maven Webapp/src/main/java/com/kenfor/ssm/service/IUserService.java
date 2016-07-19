package com.kenfor.ssm.service;

import com.kenfor.ssm.base.MyException;
import com.kenfor.ssm.model.User;

public interface IUserService {
	
	public void login(String username, String password) throws MyException;

	public boolean register(String username, String password, String email) throws MyException;

	public User findUserByUsername(String username) throws MyException;
}
