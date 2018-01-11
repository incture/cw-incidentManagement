package com.incture.im.dao;


import com.incture.im.dto.WorkOrderDto;
import com.incture.im.entity.WorkOrder;

public class WorkOrderDao {

	public WorkOrder importWorkOrder(WorkOrderDto dto) {

		WorkOrder dos = new WorkOrder();
		
		dos.setWorkType(dto.getWorkType());
		dos.setWorkEquipment(dto.getWorkEquipment());
		dos.setWorkCenter(dto.getWorkCenter());
		dos.setFuncLoc(dto.getFuncLoc());
		dos.setAssembly(dto.getAssembly());
		dos.setControlKey(dto.getControlKey());
		dos.setActivityType(dto.getActivityType());
		dos.setPlanningGroup(dto.getPlanningGroup());
		dos.setPlanningPlant(dto.getPlanningPlant());
		dos.setBusArea(dto.getBusArea());
		dos.setWorkDescription(dto.getWorkDescription());
		dos.setWorkId(dto.getWorkId());

		return dos;

	}

	public WorkOrderDto exportWorkOrder(WorkOrder dos) {

		WorkOrderDto dto = new WorkOrderDto();
		

		dto.setWorkorderId(dos.getWorkorderId());
		dto.setWorkEquipment(dos.getWorkEquipment());
		dto.setWorkCenter(dos.getWorkCenter());
		dto.setFuncLoc(dos.getFuncLoc());
		dto.setAssembly(dos.getAssembly());
		dto.setControlKey(dos.getControlKey());
		dto.setActivityType(dos.getActivityType());
		dto.setPlanningGroup(dos.getPlanningGroup());
		dto.setPlanningPlant(dos.getPlanningPlant());
		dto.setBusArea(dos.getBusArea());
		dto.setWorkDescription(dos.getWorkDescription());
		dto.setWorkId(dos.getWorkId());

		return dto;

	}

}
