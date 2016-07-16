package com.kenfor.ssm.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;
import com.kenfor.ssm.base.MyException;
import com.kenfor.ssm.model.Comment;
import com.kenfor.ssm.model.Message;
import com.kenfor.ssm.service.ICommentService;
import com.kenfor.ssm.service.IMessageService;

@Controller
public class CommentController {

	@Resource
	private IMessageService messageService;
	@Resource
	private ICommentService commentService;

	@RequestMapping("/toComment.do")
	public String toComment(HttpServletRequest request, Integer msgId,
			Integer curPage, String keyword, String startTime, String endTime) {
		if (curPage == null) {
			curPage = 1;
		}
		List<Comment> commentList = new ArrayList<Comment>();
		try {
			commentList = commentService.getCommentList(msgId, curPage, 5,
					keyword, startTime, endTime);
			PageInfo page = new PageInfo(commentList);
			int pageCount = page.getPages();
			Message message = messageService.getMessageById(msgId);
			request.setAttribute("message", message);
			request.setAttribute("curPage", curPage);
			request.setAttribute("pageCount", pageCount);
			request.setAttribute("keyword", keyword);
			request.setAttribute("startTime", startTime);
			request.setAttribute("endTime", endTime);
			request.setAttribute("commentList", commentList);
			return "comment";
		} catch (MyException e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
			return "error";
		}
	}

	@RequestMapping("/comment.do")
	public String comment(HttpServletRequest request, String content,Integer msgId) {
		String username = (String) request.getSession()
				.getAttribute("username");
		try {
			if (content.length() == 0) {
				throw new MyException("评论内容为空！");
			}
			if (username == null || "".equals(username)) {
				return "login";
			}
			commentService.comment(msgId, username, content);
			return "forward:/toComment.do";
		} catch (MyException e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
			return "error";
		}
	}
}
