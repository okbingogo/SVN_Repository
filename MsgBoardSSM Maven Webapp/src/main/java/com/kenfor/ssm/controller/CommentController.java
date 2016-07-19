package com.kenfor.ssm.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kenfor.ssm.base.MyException;
import com.kenfor.ssm.service.ICommentService;

@Controller
public class CommentController {

	@Resource
	private ICommentService commentService;

	@RequestMapping("/toComment.do")
	public String toComment(ModelMap model, Integer msgId, Integer curPage,
			String keyword, String startTime, String endTime) {
		
		model.addAttribute("msgId", msgId);
		model.addAttribute("curPage", (curPage == null) ? 1 : curPage);
		model.addAttribute("keyword", (keyword == null) ? "" : keyword);
		model.addAttribute("startTime", (startTime == null) ? "" : startTime);
		model.addAttribute("endTime", (endTime == null) ? "" : endTime);
		
		return "comment";
	}

	@RequestMapping("/comment.do")
	public String comment(HttpServletRequest request, String content,
			Integer msgId) {
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
