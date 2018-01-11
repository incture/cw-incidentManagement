package com.incture.im.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class WorkOrderDto implements Serializable {
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 38192977926901214L;
	private String workId;
	private String workType;
	 private String workEquipment;
	 private String workCenter;
	 private String funcLoc;
	 private String assembly;
	 private String controlKey;
	 private String activityType;
	 private String planningGroup;
	 private String planningPlant;
	 private String busArea;
	 private String workDescription;
	 private String workorderId;
	public String getWorkId() {
		return workId;
	}
	public void setWorkId(String workId) {
		this.workId = workId;
	}
	
	
	public String getWorkType() {
		return workType;
	}
	public void setWorkType(String workType) {
		this.workType = workType;
	}
	public String getWorkEquipment() {
		return workEquipment;
	}
	public void setWorkEquipment(String workEquipment) {
		this.workEquipment = workEquipment;
	}
	public String getWorkCenter() {
		return workCenter;
	}
	public void setWorkCenter(String workCenter) {
		this.workCenter = workCenter;
	}
	public String getFuncLoc() {
		return funcLoc;
	}
	public void setFuncLoc(String funcLoc) {
		this.funcLoc = funcLoc;
	}
	public String getAssembly() {
		return assembly;
	}
	public void setAssembly(String assembly) {
		this.assembly = assembly;
	}
	public String getControlKey() {
		return controlKey;
	}
	public void setControlKey(String controlKey) {
		this.controlKey = controlKey;
	}
	public String getActivityType() {
		return activityType;
	}
	public void setActivityType(String activityType) {
		this.activityType = activityType;
	}
	public String getPlanningGroup() {
		return planningGroup;
	}
	public void setPlanningGroup(String planningGroup) {
		this.planningGroup = planningGroup;
	}
	public String getPlanningPlant() {
		return planningPlant;
	}
	public void setPlanningPlant(String planningPlant) {
		this.planningPlant = planningPlant;
	}
	public String getBusArea() {
		return busArea;
	}
	public void setBusArea(String busArea) {
		this.busArea = busArea;
	}
	public String getWorkDescription() {
		return workDescription;
	}
	public void setWorkDescription(String workDescription) {
		this.workDescription = workDescription;
	}
	public String getWorkorderId() {
		return workorderId;
	}
	public void setWorkorderId(String workorderId) {
		this.workorderId = workorderId;
	}

}
