package com.kenfor.demo.struts.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

import com.kenfor.demo.base.MyException;
import com.kenfor.demo.base.StaticFreemarker;
import com.kenfor.demo.pojo.Message;
import com.kenfor.demo.service.IMessageService;
import com.kenfor.demo.struts.form.SearchForm;

public class MessageAction extends MappingDispatchAction {

	@Resource
	private IMessageService messageService;

	public ActionForward leavedMessage(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		try {
			String content = request.getParameter("content");
			String username = (String) request.getSession().getAttribute(
					"username");
			if (content.length() == 0) {
				throw new MyException("留言为空！");
			}
			if (username == null || "".equals(username)) {
				return mapping.findForward("toLogin");
			}
			messageService.leavedMessage(username, content);
			return mapping.findForward("toMessage");
		} catch (Exception me) {
			request.setAttribute("errorMsg", me.getMessage());
			StaticFreemarker.init(request, "error.ftl", "error.html");
			try {
				response.sendRedirect("error.html");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
	}

	public ActionForward toMessage(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		SearchForm searchForm = (SearchForm) form;
		List<Message> messageList = new ArrayList<Message>();
		// 获取当前页
		int curPage = 1;
		if (request.getParameter("curPage") != null) {
			curPage = Integer.valueOf(request.getParameter("curPage"));
		}
		// 获取搜索关键字
		String keyword = searchForm.getKeyword();
		// 获取开始时间
		String startTime = searchForm.getStartTime();
		// 获取结束时间
		String endTime = searchForm.getEndTime();
		try {
			messageList = messageService.getMessageList(curPage - 1, 5,
					keyword, startTime, endTime);
			Long count = messageService.getCount();
			Long pageCount = count / 5 + ((count % 5 == 0) ? 0 : 1);

			request.setAttribute("curPage", curPage);
			request.setAttribute("pageCount", pageCount);
			request.setAttribute("keyword", ((keyword == null) ? "" : keyword));
			request.setAttribute("startTime", ((startTime == null) ? ""
					: startTime));
			request.setAttribute("endTime", ((endTime == null) ? "" : endTime));
			request.setAttribute("messageList", messageList);

			StaticFreemarker.init(request, "message.ftl", "message.html");
			response.sendRedirect("message.html");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
