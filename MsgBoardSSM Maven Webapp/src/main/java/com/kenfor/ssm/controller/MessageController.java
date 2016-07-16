package com.kenfor.ssm.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;
import com.kenfor.ssm.base.MyException;
import com.kenfor.ssm.model.Message;
import com.kenfor.ssm.service.IMessageService;

@Controller
public class MessageController {

	@Resource
	private IMessageService messageService;

	@RequestMapping("/toMessage.do")
	public String toMessage(HttpServletRequest request, Integer curPage,
			String keyword, String startTime, String endTime) {
		if (curPage == null) {
			curPage = 1;
		}
		List<Message> messageList = new ArrayList<Message>();
		try {
			messageList = messageService.getMessageList(curPage, 5, keyword,
					startTime, endTime);
			PageInfo page = new PageInfo(messageList);
			int pageCount = page.getPages();
			request.setAttribute("curPage", curPage);
			request.setAttribute("pageCount", pageCount);
			request.setAttribute("keyword", keyword);
			request.setAttribute("startTime", startTime);
			request.setAttribute("endTime", endTime);
			request.setAttribute("messageList", messageList);
			return "message";
		} catch (MyException e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
			return "error";
		}
	}

	@RequestMapping("/leavedMessage.do")
	public String leavedMessage(HttpServletRequest request, String content) {
		String username = (String) request.getSession()
				.getAttribute("username");
		try {
			if (content.length() == 0) {
				throw new MyException("留言内容为空！");
			}
			if (username == null || "".equals(username)) {
				return "login";
			}
			messageService.leavedMessage(username, content);
			return "forward:/toMessage.do";
		} catch (MyException e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
			return "error";
		}
	}

}
