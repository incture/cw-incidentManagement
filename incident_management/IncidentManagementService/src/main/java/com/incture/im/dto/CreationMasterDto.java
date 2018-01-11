package com.incture.im.dto;

public class CreationMasterDto {

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
