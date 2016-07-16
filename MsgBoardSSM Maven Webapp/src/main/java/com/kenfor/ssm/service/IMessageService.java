package com.kenfor.ssm.service;

import java.util.List;

import com.kenfor.ssm.base.MyException;
import com.kenfor.ssm.model.Message;

public interface IMessageService {
	
	public List<Message> getMessageList(Integer curPage, Integer length,
			String keyword, String startTime, String endTime) throws MyException;

	public void leavedMessage(String username, String content) throws MyException;

	public Message getMessageById(Integer id) throws MyException;
	
}
