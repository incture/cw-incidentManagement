package com.incture.im.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "IM_INCIDENTINFO")
public class IncidentInfoDo implements BaseDo {

	@Id
	@Column(name = "INCIDENT_ID", nullable = false)
	private String incidentId;

	@Column(name = "INCIDENT_LOB", length = 50)
	private String incidentLob;

	@Column(name = "INCIDENT_TYPE", length = 50)
	private String incidentType;

	@Column(name = "INCIDENT_DESCRIPTION", length = 255)
	private String incidentDescription;

	@Column(name = "INCIDENT_PRIORITY", length = 20)
	private String incidentPriority;

	@Column(name = "INCIDENT_ACTION", length = 30)
	private String incidentAction;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "START_DATE")
	private Date createdDate;

	@Temporal(TemporalType.TIMESTAMP) //// check
	@Column(name = "FINISH_DATE")
	private Date finishDate;

	@Column(name = "INCIDENT_STATUS", length = 30)
	private String incidentStatus;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "REPORTED_DATE")
	private Date reportedDate;

	@Column(name = "ASSIGNED_GROUP", length = 50)
	private String assignedGroup;

	@Column(name = "ASSIGNED_TO", length = 50)
	private String assignedTo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ASSIGNED_DATE")
	private Date assignedDate;

	@OneToOne
	private WorkOrderDo workOrderDo;

	@ManyToOne
	
	private UserInfoDo users = new UserInfoDo();

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

	public String getIncidentType() {
		return incidentType;
	}

	public void setIncidentType(String incidentType) {
		this.incidentType = incidentType;
	}

	public String getIncidentAction() {
		return incidentAction;
	}

	public void setIncidentAction(String incidentAction) {
		this.incidentAction = incidentAction;
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

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date date) {
		this.createdDate = date;
	}

	public Date getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}

	public String getIncidentStatus() {
		return incidentStatus;
	}

	public void setIncidentStatus(String incidentStatus) {
		this.incidentStatus = incidentStatus;
	}

	public Date getReportedDate() {
		return reportedDate;
	}

	public void setReportedDate(Date reportedDate) {
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

	public Date getAssignedDate() {
		return assignedDate;
	}

	public void setAssignedDate(Date assignedDate) {
		this.assignedDate = assignedDate;
	}

	public WorkOrderDo getWorkOrder() {
		return workOrderDo;
	}

	public void setWorkOrder(WorkOrderDo workOrderDo) {
		this.workOrderDo = workOrderDo;
	}

	public UserInfoDo getUsers() {
		return users;
	}

	public void setUsers(UserInfoDo users) {
		this.users = users;
	}

	public Object getPrimaryKey() {
		// TODO Auto-generated method stub
		return null;
	}

}
