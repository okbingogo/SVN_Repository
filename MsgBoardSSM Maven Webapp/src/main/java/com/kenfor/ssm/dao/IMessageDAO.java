package com.kenfor.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kenfor.ssm.model.Message;

public interface IMessageDAO {
    int deleteByPrimaryKey(Integer msgId);

    int insert(Message record);

    int insertSelective(Message record);

    Message selectByPrimaryKey(Integer msgId);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);

	List<Message> selectBySearch(@Param("keyword")String keyword, @Param("startTime")String startTime,
			@Param("endTime")String endTime);

}