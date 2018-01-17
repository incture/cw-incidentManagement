package com.incture.im.dao;


import javax.persistence.Query;

import org.hibernate.Session;

import com.incture.im.dto.IncidentApprovalDto;
import com.incture.im.dto.IncidentInfoDto;
import com.incture.im.dto.UserInfoDto;
import com.incture.im.dto.WorkOrderDto;
import com.incture.im.entity.IncidentInfoDo;
import com.incture.im.entity.UserInfoDo;
import com.incture.im.entity.WorkOrderDo;

public class IncidentApprovalDao extends BaseDao {
	
	
	public IncidentApprovalDto searchApprovalIncident(String incidentId) {
		
		Session session = getSession();

		String queryString = "select incident from IncidentInfoDo incident where incident.incidentId =:id ";
		Query query = session.createQuery(queryString);
		query.setParameter("id", incidentId);

		@SuppressWarnings("rawtypes")
		IncidentInfoDo incidentDo = (IncidentInfoDo) ((org.hibernate.query.Query) query).uniqueResult();

		UserInfoDo userDoList = incidentDo.getUsers();

		UserInfoDao userDao = new UserInfoDao();
		UserInfoDto userDto = new UserInfoDto();

			userDto = userDao.exportUserInfo(userDoList);

		
		IncidentInfoDao incidentDao = new IncidentInfoDao();
		IncidentInfoDto incidentDto = new IncidentInfoDto();

		incidentDto = incidentDao.exportIncidentInfo(incidentDo);

		WorkOrderDo workOrderDo = incidentDo.getWorkOrder();
		WorkOrderDao workOrderDao = new WorkOrderDao();
		WorkOrderDto workOrderDto = new WorkOrderDto();

		workOrderDto = workOrderDao.exportWorkOrder(workOrderDo);

		IncidentApprovalDto approve = new IncidentApprovalDto();

		approve.setUser(userDto);
		approve.setIncident(incidentDto);
		approve.setWo(workOrderDto);

		return approve;

	}

}
