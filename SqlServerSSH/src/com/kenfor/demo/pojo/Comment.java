package com.kenfor.demo.pojo;

import java.sql.Timestamp;

/**
 * Comment entity. @author MyEclipse Persistence Tools
 */

public class Comment implements java.io.Serializable {

	// Fields

	private Integer commId;
	private String fromName;
	private Integer msgId;
	private String commContent;
	private Timestamp commTime;

	// Constructors

	/** default constructor */
	public Comment() {
	}

	/** full constructor */
	public Comment(String fromName, Integer msgId, String commContent,
			Timestamp commTime) {
		this.fromName = fromName;
		this.msgId = msgId;
		this.commContent = commContent;
		this.commTime = commTime;
	}

	// Property accessors

	public Integer getCommId() {
		return this.commId;
	}

	public void setCommId(Integer commId) {
		this.commId = commId;
	}

	public String getFromName() {
		return this.fromName;
	}

	public void setFromName(String fromName) {
		this.fromName = fromName;
	}

	public Integer getMsgId() {
		return this.msgId;
	}

	public void setMsgId(Integer msgId) {
		this.msgId = msgId;
	}

	public String getCommContent() {
		return this.commContent;
	}

	public void setCommContent(String commContent) {
		this.commContent = commContent;
	}

	public Timestamp getCommTime() {
		return this.commTime;
	}

	public void setCommTime(Timestamp commTime) {
		this.commTime = commTime;
	}

}