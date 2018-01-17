package com.incture.im.services;

import java.text.ParseException;

import com.incture.im.dao.IncidentCreationDao;
import com.incture.im.dto.IncidentCreationDto;
import com.incture.im.dto.ResponseDto;

public class CreateIncidentServiceImp implements CreateIncidentService {
	
	
	@Override
	public ResponseDto createIncident(IncidentCreationDto createIncident){
		
		ResponseDto response = new ResponseDto();

		IncidentCreationDao incident = new IncidentCreationDao();

		try {
			
			return incident.createIncident(createIncident);
			
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			response.setStatus(false);
			response.setMessage("Failure");
		}
		
		return response;
		
	}

}
