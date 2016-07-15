package com.kenfor.demo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.kenfor.demo.dao.ICommentDAO;
import com.kenfor.demo.pojo.Comment;
import com.kenfor.demo.service.ICommentService;

@Service
public class CommentService implements ICommentService {
	@Resource
	private ICommentDAO commentDAO;

	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public List<Comment> getCommentList(Integer msgId, Integer curPage,
			Integer length, String keyword, String startTime, String endTime)
			throws Exception {
		return commentDAO.queryForPage(msgId, curPage, length, keyword,
				startTime, endTime);
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public void comment(Integer msgId, String username, String content)
			throws Exception {
		Comment comment = new Comment();
		comment.setMsgId(msgId);
		comment.setFromName(username);
		comment.setCommContent(content);
		commentDAO.save(comment);
	}

	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public Long getCount() throws Exception {
		return commentDAO.getAllRowCount();
	}

}
