package com.kenfor.demo.service;

import java.util.List;

import com.kenfor.demo.pojo.User;

public interface IUserService {
	public void login(String username, String password) throws Exception;

	public void register(String username, String password, String email) throws Exception;

	public List<User> getUserList() throws Exception;

	public User findUserByUsername(String username) throws Exception;
}
