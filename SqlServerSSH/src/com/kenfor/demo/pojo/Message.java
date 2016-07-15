package com.kenfor.demo.pojo;

import java.sql.Timestamp;

/**
 * Message entity. @author MyEclipse Persistence Tools
 */

public class Message implements java.io.Serializable {

	// Fields

	private Integer msgId;
	private String fromName;
	private String msgContent;
	private Timestamp msgTime;

	// Constructors

	/** default constructor */
	public Message() {
	}

	/** full constructor */
	public Message(String fromName, String msgContent, Timestamp msgTime) {
		this.fromName = fromName;
		this.msgContent = msgContent;
		this.msgTime = msgTime;
	}

	// Property accessors

	public Integer getMsgId() {
		return this.msgId;
	}

	public void setMsgId(Integer msgId) {
		this.msgId = msgId;
	}

	public String getFromName() {
		return this.fromName;
	}

	public void setFromName(String fromName) {
		this.fromName = fromName;
	}

	public String getMsgContent() {
		return this.msgContent;
	}

	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}

	public Timestamp getMsgTime() {
		return this.msgTime;
	}

	public void setMsgTime(Timestamp msgTime) {
		this.msgTime = msgTime;
	}

}