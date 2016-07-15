package com.kenfor.demo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.kenfor.demo.dao.IMessageDAO;
import com.kenfor.demo.pojo.Message;
import com.kenfor.demo.service.IMessageService;
@Service
public class MessageService implements IMessageService {
	@Resource
	private IMessageDAO messageDAO;

	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public List<Message> getMessageList(Integer curPage, Integer length,
			String keyword, String startTime, String endTime) throws Exception {
		return messageDAO.queryForPage(curPage, length, keyword,
				startTime, endTime);
	}

	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public Long getCount() throws Exception {
		return messageDAO.getAllRowCount();
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public void leavedMessage(String username, String content) throws Exception {
		Message message = new Message();
		message.setFromName(username);
		message.setMsgContent(content);
		messageDAO.save(message);
	}

	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public Message getMessageById(Integer id) throws Exception {
		return messageDAO.findById(id);
	}

}
