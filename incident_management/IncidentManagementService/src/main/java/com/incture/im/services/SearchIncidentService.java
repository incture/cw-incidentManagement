package com.incture.im.services;

import java.util.List;

import com.incture.im.dto.IncidentInfoDto;
import com.incture.im.dto.IncidentTableInfoDto;
import com.incture.im.dto.SearchIncidentDto;

public interface SearchIncidentService {

	List<IncidentTableInfoDto> getIncidentTableInfo(SearchIncidentDto searchIncidentTable);

	IncidentInfoDto getIncidentById(String id);

}
