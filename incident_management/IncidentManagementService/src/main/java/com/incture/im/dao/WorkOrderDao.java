package com.incture.im.dao;

import com.incture.im.dto.WorkOrderDto;
import com.incture.im.entity.WorkOrderDo;

public class WorkOrderDao extends BaseDao {

	public WorkOrderDo importWorkOrder(WorkOrderDto dto) {

		WorkOrderDo dos = new WorkOrderDo();

		dto.setWorkId(SequenceNumberGen.getInstance().getNextSeqNumber("WO", 5, getSession()));
		
		String workOrderId = dto.getWorkorderId();
		
		String[] splitWorkOrder = workOrderId.split(" ");

		dos.setWorkId(dto.getWorkId());
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
		dos.setWorkorderId(splitWorkOrder[1]);

		return dos;

	}

	public WorkOrderDto exportWorkOrder(WorkOrderDo dos) {

		WorkOrderDto dto = new WorkOrderDto();

		dto.setWorkId(dos.getWorkId());
		dto.setWorkType(dos.getWorkType());
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
		dto.setWorkorderId(dos.getWorkorderId());

		return dto;

	}

}
