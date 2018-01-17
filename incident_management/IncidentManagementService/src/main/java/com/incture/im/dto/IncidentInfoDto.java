package com.incture.im.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class IncidentInfoDto extends BaseDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6315185101584626842L;
	private String incidentId;
	private String incidentLob;
	private String incidentType;
	private String incidentDescription;
	private String incidentPriority;
	private String incidentAction;
	private String createdDate;
	private String finishDate;
	private String incidentStatus;
	private String reportedDate;
	private String assignedGroup;
	private String assignedTo;
	private String assignedDate;

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

	public String getIncidentType() {
		return incidentType;
	}

	public void setIncidentType(String incidentType) {
		this.incidentType = incidentType;
	}

	public String getIncidentDescription() {
		return incidentDescription;
	}

	public void setIncidentDescription(String incidentDescription) {
		this.incidentDescription = incidentDescription;
	}

	public String getIncidentPriority() {
		return incidentPriority;
	}

	public void setIncidentPriority(String incidentPriority) {
		this.incidentPriority = incidentPriority;
	}
	
	public String getIncidentAction() {
		return incidentAction;
	}

	public void setIncidentAction(String incidentAction) {
		this.incidentAction = incidentAction;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String date) {
		this.createdDate = date;
	}

	public String getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(String finishDate) {
		this.finishDate = finishDate;
	}

	public String getIncidentStatus() {
		return incidentStatus;
	}

	public void setIncidentStatus(String incidentStatus) {
		this.incidentStatus = incidentStatus;
	}

	public String getReportedDate() {
		return reportedDate;
	}

	public void setReportedDate(String reportedDate) {
		this.reportedDate = reportedDate;
	}

	public String getAssignedGroup() {
		return assignedGroup;
	}

	public void setAssignedGroup(String assignedGroup) {
		this.assignedGroup = assignedGroup;
	}

	public String getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}

	public String getAssignedDate() {
		return assignedDate;
	}

	public void setAssignedDate(String assignedDate) {
		this.assignedDate = assignedDate;
	}

}
