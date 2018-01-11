package com.incture.im.services;

import java.util.List;

import com.incture.im.dto.ApprovalMasterDto;
import com.incture.im.dto.CreationMasterDto;
import com.incture.im.dto.IncidentInfoDto;
import com.incture.im.dto.IncidentTableMasterDto;
import com.incture.im.dto.SearchIncidentMasterDto;
import com.incture.im.dto.UserInfoDto;

public interface IncidentManagementService {

	String createRecord(CreationMasterDto createIncident);

	UserInfoDto getUserById(String userId);

	List<IncidentTableMasterDto> getIncidentTableInfo(SearchIncidentMasterDto searchIncidentTable);

	IncidentInfoDto getIncidentById(String id);

	ApprovalMasterDto searchApprovalIncident(String incidentId);

	List<IncidentInfoDto> getAllIncidents();

}
