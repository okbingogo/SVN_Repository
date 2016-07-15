package com.kenfor.demo.struts.form;

import org.apache.struts.action.ActionForm;

public class SearchForm extends ActionForm {

	private static final long serialVersionUID = 3191800228143701386L;

	private String keyword;
	private String startTime;
	private String endTime;

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
