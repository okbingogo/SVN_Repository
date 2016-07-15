package com.kenfor.demo.service;

import java.util.List;

import com.kenfor.demo.pojo.Comment;

public interface ICommentService {

	public List<Comment> getCommentList(Integer msgId, Integer curPage,
			Integer length, String keyword, String startTime, String endTime)
			throws Exception;

	public void comment(Integer msgId, String username, String content)
			throws Exception;

	public Long getCount() throws Exception;
}
