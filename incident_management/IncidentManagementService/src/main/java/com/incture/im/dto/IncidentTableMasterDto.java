package com.incture.im.dto;

import java.util.Date;

public class IncidentTableMasterDto {

	private String incidentId;
	private String incidentLob;
	private String incidentPriority;
	private String incidentStatus;
	private Date createdDate;
	private Date finishDate;

	public String getIncidentId() {
		return incidentId;
	}

	public void setIncidentId(String incidentId) {
		this.incidentId = incidentId;
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

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}

}
