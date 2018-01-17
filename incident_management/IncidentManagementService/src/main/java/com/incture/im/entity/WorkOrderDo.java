package com.incture.im.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="IM_WORKORDER")
public class WorkOrderDo implements BaseDo {
	
	
	@Id
	@Column(name="WORK_ID",nullable=false)
	
	 private String workId;
	
	@Column(name="WORK_TYPE",length = 4)
	
	private String workType;
	
	@Column(name="WORK_EQUIPMENT", length=18)
	private String workEquipment;
	
	@Column(name="WORK_CENTER", length=8)
	private String workCenter;
	
	@Column(name="FUNC_LOCATION", length=30)
	private String funcLoc;
	
	@Column(name="ASSEMBLY", length=18)
	private String assembly;
	
	@Column(name="CONTROL_KEY", length=4)
	private String controlKey;
	
	@Column(name="ACTIVITY_TYPE", length=6)
	private String activityType;
	
	@Column(name="PLANNING_GROUP", length=3)
	private String planningGroup;
	
	@Column(name="PLANNING_PLANT", length=4)
	private String planningPlant;
	
	@Column(name="BUSINESS_AREA", length=4)
	private String busArea;
	
	@Column(name="WORKORDER_DESC", length=40)
	private String workDescription;
	
	@Column(name="WORKORDER_ID", length=10)
	private String workorderId;

	public String getWorkType() {
		return workType;
	}

	public void setWorkType(String workType) {
		this.workType = workType;
	}

	public String getWorkId() {
		return workId;
	}

	public void setWorkId(String workId) {
		this.workId = workId;
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
