package com.incture.im.dao;

import com.incture.im.dto.IncidentInfoDto;
import com.incture.im.entity.IncidentInfo;

public class IncidentInfoDao {

	public IncidentInfo importIncidentInfo(IncidentInfoDto dto) {

		IncidentInfo dos = new IncidentInfo();
		
		dos.setIncidentLob(dto.getIncidentLob());
		dos.setIncidentType(dto.getIncidentType());
		dos.setIncidentDescription(dto.getIncidentDescription());
		dos.setIncidentPriority(dto.getIncidentPriority());
		dos.setIncidentAction(dto.getIncidentAction());
		dos.setCreatedDate(dto.getCreatedDate());
		dos.setFinishDate(dto.getFinishDate());
		dos.setIncidentStatus(dto.getIncidentStatus());
		dos.setReportedDate(dto.getReportedDate());
		dos.setAssignedGroup(dto.getAssignedGroup());
		dos.setAssignedTo(dto.getAssignedTo());
		dos.setAssignedDate(dto.getAssignedDate());

		return dos;

	}

	public IncidentInfoDto exportIncidentInfo(IncidentInfo dos) {

		IncidentInfoDto dto = new IncidentInfoDto();
		

		dto.setIncidentId(dos.getIncidentId());
		dto.setIncidentLob(dos.getIncidentLob());
		dto.setIncidentType(dos.getIncidentType());
		dto.setIncidentDescription(dos.getIncidentDescription());
		dto.setIncidentPriority(dos.getIncidentPriority());
		dto.setIncidentAction(dos.getIncidentAction());
		dto.setCreatedDate(dos.getCreatedDate());
		dto.setFinishDate(dos.getFinishDate());
		dto.setIncidentStatus(dos.getIncidentStatus());
		dto.setReportedDate(dos.getReportedDate());
		dto.setAssignedGroup(dos.getAssignedGroup());
		dto.setAssignedTo(dos.getAssignedTo());
		dto.setAssignedDate(dos.getAssignedDate());

		return dto;

	}

}
