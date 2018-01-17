package com.incture.im.services;

import java.util.List;

import com.incture.im.dto.IncidentApprovalDto;
import com.incture.im.dto.IncidentInfoDto;

public interface ApproveIncidentService {

	IncidentApprovalDto searchApprovalIncident(String incidentId);

	List<IncidentInfoDto> getAllIncidents();

}
