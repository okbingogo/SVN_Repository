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

import com.kenfor.demo.service.ICommentService;
import com.kenfor.demo.service.IMessageService;
import com.kenfor.demo.base.MyException;
import com.kenfor.demo.base.StaticFreemarker;
import com.kenfor.demo.pojo.Comment;
import com.kenfor.demo.pojo.Message;
import com.kenfor.demo.struts.form.SearchForm;

public class CommentAction extends MappingDispatchAction {

	@Resource
	private ICommentService commentService;
	@Resource
	private IMessageService messageService;

	public ActionForward toComment(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		SearchForm searchForm = (SearchForm) form;
		List<Comment> commentList = new ArrayList<Comment>();
		// 获取当前页
		int curPage = 1;
		if (request.getParameter("curPage") != null) {
			curPage = Integer.valueOf(request.getParameter("curPage"));
		}
		// 获取所属留言ID
		Integer msgId = Integer.valueOf(request.getParameter("msgId"));
		// 获取搜索关键字
		String keyword = searchForm.getKeyword();
		// 获取开始时间
		String startTime = searchForm.getStartTime();
		// 获取结束时间
		String endTime = searchForm.getEndTime();
		try {
			// 获取评论列表
			commentList = commentService.getCommentList(msgId, curPage - 1, 5,
					keyword, startTime, endTime);
			// 获取评论总数
			Long count = commentService.getCount();
			// 计算分页总页数
			Long pageCount = count / 5 + ((count % 5 == 0) ? 0 : 1);
			// 获取当前评论所属留言
			Message message = messageService.getMessageById(msgId);

			request.setAttribute("message", message);
			request.setAttribute("curPage", curPage);
			request.setAttribute("pageCount", pageCount);
			request.setAttribute("keyword", ((keyword == null) ? "" : keyword));
			request.setAttribute("startTime", ((startTime == null) ? ""
					: startTime));
			request.setAttribute("endTime", ((endTime == null) ? "" : endTime));
			request.setAttribute("commentList", commentList);
			StaticFreemarker.init(request, "comment.ftl", "comment.html");
			response.sendRedirect("comment.html");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ActionForward comment(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		// 获取评论内容
		String content = request.getParameter("content");
		// 获取当前用户名
		String username = (String) request.getSession()
				.getAttribute("username");
		try {
			if (content.length() == 0) {
				throw new MyException("评论内容为空！");
			}

			if (username == null || "".equals(username)) {
				return mapping.findForward("toLogin");
			}
			if (request.getParameter("msgId") == null) {
				Integer msgId = Integer.valueOf(request.getParameter("msgId"));
				commentService.comment(msgId, username, content);
				return mapping.findForward("toMessage");
			}
			Integer msgId = Integer.valueOf(request.getParameter("msgId"));
			commentService.comment(msgId, username, content);
			return mapping.findForward("toComment");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
			StaticFreemarker.init(request, "error.ftl", "error.html");
			try {
				response.sendRedirect("error.html");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			return null;
		}
	}
}
