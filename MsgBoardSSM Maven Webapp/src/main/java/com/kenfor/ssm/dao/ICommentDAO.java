package com.kenfor.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kenfor.ssm.model.Comment;

public interface ICommentDAO {
    int deleteByPrimaryKey(Integer commId);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Integer commId);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);

	List<Comment> selectBySearch(@Param("msgId")Integer msgId, @Param("keyword")String keyword,
			@Param("startTime")String startTime, @Param("endTime")String endTime);
}