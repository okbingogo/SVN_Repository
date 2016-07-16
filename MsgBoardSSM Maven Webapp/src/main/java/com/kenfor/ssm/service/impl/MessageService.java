package com.kenfor.ssm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.kenfor.ssm.base.MyException;
import com.kenfor.ssm.dao.IMessageDAO;
import com.kenfor.ssm.model.Message;
import com.kenfor.ssm.service.IMessageService;

@Service
public class MessageService implements IMessageService {

	private static final Logger log = Logger.getLogger(MessageService.class);
	@Resource
	private IMessageDAO messageDAO;

	@Override
	public List<Message> getMessageList(Integer curPage, Integer length,
			String keyword, String startTime, String endTime)
			throws MyException {
		log.info(new StringBuilder("获取留言列表：curPage==>").append(curPage)
				.append(",length==>").append(length).append(",keyword==>")
				.append(keyword).append(",startTime==>").append(startTime)
				.append(",endTime==>").append(endTime).toString());
		try {
			if (keyword != null && !"".equals(keyword)) {
				keyword = new StringBuilder("%").append(keyword).append('%').toString();
				System.out.println(keyword);
			}
			PageHelper.startPage(curPage, length);
			List<Message> messageList = messageDAO.selectBySearch(keyword, startTime, endTime);
			return messageList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException("获取留言列表失败，请重试！");
		}
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void leavedMessage(String username, String content)
			throws MyException {
		log.info(new StringBuilder("添加留言：username==>").append(username)
				.append(",content==>").append(content).toString());
		try {
			Message message = new Message();
			message.setFromName(username);
			message.setMsgContent(content);
			if (messageDAO.insert(message) == 1) {
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException("添加留言失败，请重试！");
		}

	}

	@Override
	public Message getMessageById(Integer id) throws MyException {
		log.info(new StringBuilder("获取id留言：id==>").append(id));
		try {
			return messageDAO.selectByPrimaryKey(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException("获取留言失败，请重试！");
		}
	}

}
