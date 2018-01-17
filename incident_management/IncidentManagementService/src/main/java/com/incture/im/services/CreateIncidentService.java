package com.incture.im.services;


import com.incture.im.dto.IncidentCreationDto;
import com.incture.im.dto.ResponseDto;

public interface CreateIncidentService {

	ResponseDto createIncident(IncidentCreationDto createIncident);

}
