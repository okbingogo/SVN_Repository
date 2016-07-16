package com.kenfor.ssm.service;

import java.util.List;

import com.kenfor.ssm.base.MyException;
import com.kenfor.ssm.model.Comment;


public interface ICommentService {

	public List<Comment> getCommentList(Integer msgId, Integer curPage,
			Integer length, String keyword, String startTime, String endTime)
			throws MyException;

	public void comment(Integer msgId, String username, String content)
			throws MyException;

}
