package com.kenfor.demo.struts.form;

import org.apache.struts.action.ActionForm;

public class UserForm extends ActionForm {
	
	private static final long serialVersionUID = -4277620199419419697L;
	
	private String username;
	private String password;
	private String email;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
