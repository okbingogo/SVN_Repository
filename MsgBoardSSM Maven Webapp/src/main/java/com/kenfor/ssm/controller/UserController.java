package com.kenfor.ssm.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kenfor.ssm.base.MyException;
import com.kenfor.ssm.service.IUserService;

@Controller
public class UserController {
	@Resource
	private IUserService userService;

	@RequestMapping("/toLogin.do")
	public String toLogin() {
		return "login";
	}

	@RequestMapping("/toRegister.do")
	public String toRegister() {
		return "login";
	}

	@RequestMapping("/logout.do")
	public String logout(HttpServletRequest request) {
		request.getSession().removeAttribute("username");
		return "redirect:/index.do";
	}

	@RequestMapping("/login.do")
	public String login(HttpServletRequest request, String username,
			String password) {
		try {
			userService.login(username, password);
			request.getSession().setAttribute("username", username);
			return "forward:/index.do";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
			return "error";
		}
	}

	@RequestMapping("/register.do")
	public String register(HttpServletRequest request, String username,
			String password, String email) {
		try {
			userService.register(username, password, email);
			request.getSession().setAttribute("username", username);
			return "forward:/index.do";
		} catch (MyException e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
			return "error";
		}
	}
}
