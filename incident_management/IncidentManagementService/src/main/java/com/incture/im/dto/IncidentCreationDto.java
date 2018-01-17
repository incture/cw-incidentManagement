package com.incture.im.dto;

import java.io.Serializable;

public class IncidentCreationDto extends BaseDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3155533341369157190L;
	String userId;
	IncidentInfoDto incident;
	WorkOrderDto wo;

	public IncidentInfoDto getIncident() {
		return incident;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setIncident(IncidentInfoDto incident) {
		this.incident = incident;
	}

	public WorkOrderDto getWo() {
		return wo;
	}

	public void setWo(WorkOrderDto wo) {
		this.wo = wo;
	}

}
