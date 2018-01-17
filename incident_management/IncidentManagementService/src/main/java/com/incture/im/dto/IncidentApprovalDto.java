package com.incture.im.dto;
import java.io.Serializable;

public class IncidentApprovalDto extends BaseDto implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -261258409867600789L;
	UserInfoDto user;
	IncidentInfoDto incident;
	WorkOrderDto wo;

	public UserInfoDto getUser() {
		return user;
	}

	public void setUser(UserInfoDto user) {
		this.user = user;
	}

	public IncidentInfoDto getIncident() {
		return incident;
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
