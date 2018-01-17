package com.incture.im.dao;

import java.text.ParseException;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.incture.im.dto.IncidentCreationDto;
import com.incture.im.dto.IncidentInfoDto;
import com.incture.im.dto.ResponseDto;
import com.incture.im.dto.WorkOrderDto;

import com.incture.im.entity.IncidentInfoDo;

import com.incture.im.entity.UserInfoDo;
import com.incture.im.entity.WorkOrderDo;


public class IncidentCreationDao extends BaseDao {
	
	
	public ResponseDto createIncident(IncidentCreationDto createIncident) throws ParseException {
		
		ResponseDto response = new ResponseDto();

		IncidentInfoDto incidentDto = new IncidentInfoDto();
		incidentDto = createIncident.getIncident();

		IncidentInfoDo incidentDo = new IncidentInfoDo();
		IncidentInfoDao incidentDao = new IncidentInfoDao();
		incidentDo = incidentDao.importIncidentInfo(incidentDto);

		WorkOrderDto workOrderDto = new WorkOrderDto();
		workOrderDto = createIncident.getWo();

		WorkOrderDo workOrderDo = new WorkOrderDo();
		WorkOrderDao workOrderDao = new WorkOrderDao();
		workOrderDo = workOrderDao.importWorkOrder(workOrderDto);
		
		try{
		
		Session session = getSession();
		
		Transaction tx = session.beginTransaction();

		Query q = session.createQuery("from UserInfoDo where userId =:uid");
		String id = createIncident.getUserId();
		q.setParameter("uid", id);

		@SuppressWarnings("rawtypes")
		UserInfoDo userDo = (UserInfoDo) ((org.hibernate.query.Query) q).uniqueResult();

		incidentDo.setWorkOrder(workOrderDo);
		userDo.getIncidents().add(incidentDo);
		incidentDo.setUsers(userDo);

		session.save(workOrderDo);
		session.save(incidentDo);
		//session.save(userDo);

		tx.commit();
		
		response.setStatus(true);
		response.setMessage("Success");
		}catch(Exception e){
			
			e.printStackTrace();
			response.setStatus(false);
			response.setMessage("Failure");
		}
		
	
		return response;

	}
	
	

}
