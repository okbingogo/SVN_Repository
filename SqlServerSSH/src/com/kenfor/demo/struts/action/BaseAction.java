package com.kenfor.demo.struts.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

import com.kenfor.demo.base.StaticFreemarker;

public class BaseAction extends MappingDispatchAction {
	
	public ActionForward toLogin(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		StaticFreemarker.init(request, "login.ftl", "login.html");
		try {
			response.sendRedirect("login.html");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ActionForward toRegister(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		StaticFreemarker.init(request, "register.ftl", "register.html");
		try {
			response.sendRedirect("register.html");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ActionForward index(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		return mapping.findForward("toMessage");
	}
	
	
}
