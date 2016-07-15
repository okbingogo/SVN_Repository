package com.kenfor.demo.struts.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

import com.kenfor.demo.base.StaticFreemarker;
import com.kenfor.demo.service.IUserService;
import com.kenfor.demo.struts.form.UserForm;

public class UserAction extends MappingDispatchAction {
	@Resource
	private IUserService userService;

	public ActionForward logout(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.getSession().removeAttribute("username");
		return mapping.findForward("index");
	}

	public ActionForward login(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		try {
			UserForm userForm = (UserForm) form;
			userService.login(userForm.getUsername(), userForm.getPassword());
			request.getSession().setAttribute("username",
					userForm.getUsername());
			System.out.println(request.getSession().getAttribute("username"));
			return mapping.findForward("index");
		} catch (Exception e) {
			e.printStackTrace();
			try {
				request.setAttribute("errorMsg", "登录失败！！");
				StaticFreemarker.init(request, "error.ftl", "error.html");
				response.sendRedirect("error.html");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		return null;
	}

	public ActionForward register(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		UserForm userForm = (UserForm) form;
		try {
			userService.register(userForm.getUsername(), userForm.getPassword(), userForm.getEmail());
			request.getSession().setAttribute("username", userForm.getUsername());
			return mapping.findForward("index");
		} catch (Exception e) {
			e.printStackTrace();
			try {
				request.setAttribute("errorMsg", "注册失败！！");
				StaticFreemarker.init(request, "error.ftl", "error.html");
				response.sendRedirect("error.html");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		return null;
	}

}
