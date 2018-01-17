package com.incture.im.dto;

import java.io.Serializable;

public class SearchIncidentDto extends BaseDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1090203031984460639L;
	private String lineOfBusiness;
	private String priority;
	private String status;

	public String getLineOfBusiness() {
		return lineOfBusiness;
	}

	public void setLineOfBusiness(String lineOfBusiness) {
		this.lineOfBusiness = lineOfBusiness;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
