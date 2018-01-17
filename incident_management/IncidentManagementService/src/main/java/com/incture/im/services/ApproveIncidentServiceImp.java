package com.incture.im.services;

import java.util.List;

import com.incture.im.dao.IncidentApprovalDao;
import com.incture.im.dao.IncidentInfoDao;
import com.incture.im.dto.IncidentApprovalDto;
import com.incture.im.dto.IncidentInfoDto;

public class ApproveIncidentServiceImp implements ApproveIncidentService {
	
	@Override
	public IncidentApprovalDto searchApprovalIncident(String incidentId) {

		IncidentApprovalDao incidentApprove = new IncidentApprovalDao();

		return incidentApprove.searchApprovalIncident(incidentId);

	}
	
	@Override
	public List<IncidentInfoDto> getAllIncidents() {

		IncidentInfoDao allIncidents = new IncidentInfoDao();

		return allIncidents.getAllIncidents();

	}
	

}
