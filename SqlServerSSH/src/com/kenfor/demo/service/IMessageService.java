package com.kenfor.demo.service;

import java.util.List;

import com.kenfor.demo.pojo.Message;

public interface IMessageService {
	
	public List<Message> getMessageList(Integer curPage, Integer length,
			String keyword, String startTime, String endTime) throws Exception;

	public Long getCount() throws Exception;

	public void leavedMessage(String username, String content) throws Exception;

	public Message getMessageById(Integer id) throws Exception;
	
}
