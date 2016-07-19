package com.kenfor.ssm.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kenfor.ssm.base.MyException;
import com.kenfor.ssm.service.IMessageService;

@Controller
public class MessageController {

	@Resource
	private IMessageService messageService;

	@RequestMapping("/toMessage.do")
	public String toMessage(ModelMap model, Integer curPage, String keyword,
			String startTime, String endTime) {
		model.addAttribute("curPage", (curPage == null) ? 1 : curPage);
		model.addAttribute("keyword", (keyword == null) ? "" : keyword);
		model.addAttribute("startTime", (startTime == null) ? "" : startTime);
		model.addAttribute("endTime", (endTime == null) ? "" : endTime);
		return "message";
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
