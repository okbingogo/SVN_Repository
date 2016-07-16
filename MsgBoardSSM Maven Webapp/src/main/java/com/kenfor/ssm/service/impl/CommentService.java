package com.kenfor.ssm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.kenfor.ssm.base.MyException;
import com.kenfor.ssm.dao.ICommentDAO;
import com.kenfor.ssm.model.Comment;
import com.kenfor.ssm.service.ICommentService;
@Service
public class CommentService implements ICommentService {

	private static final Logger log = Logger.getLogger(CommentService.class);
	@Resource
	private ICommentDAO commentDAO;

	@Override
	public List<Comment> getCommentList(Integer msgId, Integer curPage,
			Integer length, String keyword, String startTime, String endTime)
			throws MyException {
		log.info(new StringBuilder("获取评论列表：curPage==>").append(curPage)
				.append(",length==>").append(length).append(",keyword==>")
				.append(keyword).append(",startTime==>").append(startTime)
				.append(",endTime==>").append(endTime).toString());
		try {
			if (keyword != null && !"".equals(keyword)) {
				keyword = new StringBuilder("%").append(keyword).append('%').toString();
			}
			PageHelper.startPage(curPage, length);
			List<Comment> commentList = commentDAO.selectBySearch(msgId,
					keyword, startTime, endTime);
			return commentList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException("获取评论列表失败，请重试！");
		}
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void comment(Integer msgId, String username, String content)
			throws MyException {
		log.info(new StringBuilder("添加评论：msgId==>").append(msgId)
				.append(",username==>").append(username).append(",content==>")
				.append(content).toString());
		try {
			Comment comment = new Comment();
			comment.setMsgId(msgId);
			comment.setFromName(username);
			comment.setCommContent(content);
			if (commentDAO.insert(comment) == 1) {
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException("添加评论失败，请重试！");
		}

	}

}
