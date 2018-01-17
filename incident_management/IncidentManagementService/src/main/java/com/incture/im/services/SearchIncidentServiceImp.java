package com.incture.im.services;

import java.util.List;

import com.incture.im.dao.IncidentInfoDao;
import com.incture.im.dao.IncidentTableInfoDao;
import com.incture.im.dto.IncidentInfoDto;
import com.incture.im.dto.IncidentTableInfoDto;
import com.incture.im.dto.SearchIncidentDto;

public class SearchIncidentServiceImp implements SearchIncidentService {
	
	
	@Override
	public List<IncidentTableInfoDto> getIncidentTableInfo(SearchIncidentDto searchIncidentTable) {

		IncidentTableInfoDao incidentTable = new IncidentTableInfoDao();

		return incidentTable.searchIncidentTableInfo(searchIncidentTable);
	}
	
	@Override
	public IncidentInfoDto getIncidentById(String id) {

		IncidentInfoDao incidentById = new IncidentInfoDao();

		return incidentById.getIncidentById(id);
	}

}
