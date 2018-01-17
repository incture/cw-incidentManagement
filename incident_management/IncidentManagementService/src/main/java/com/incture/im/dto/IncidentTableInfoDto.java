package com.incture.im.dto;

import java.io.Serializable;


public class IncidentTableInfoDto extends BaseDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6126345798514134356L;
	private String incidentId;
	private String incidentLob;
	private String incidentPriority;
	private String incidentStatus;
	private String createdDate;
	private String finishDate;

	public String getIncidentId() {
		return incidentId;
	}

	public void setIncidentId(String string) {
		this.incidentId = string;
	}

	public String getIncidentLob() {
		return incidentLob;
	}

	public void setIncidentLob(String incidentLob) {
		this.incidentLob = incidentLob;
	}

	public String getIncidentPriority() {
		return incidentPriority;
	}

	public void setIncidentPriority(String incidentPriority) {
		this.incidentPriority = incidentPriority;
	}

	public String getIncidentStatus() {
		return incidentStatus;
	}

	public void setIncidentStatus(String incidentStatus) {
		this.incidentStatus = incidentStatus;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String string) {
		this.createdDate = string;
	}

	public String getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(String string) {
		this.finishDate = string;
	}

}
