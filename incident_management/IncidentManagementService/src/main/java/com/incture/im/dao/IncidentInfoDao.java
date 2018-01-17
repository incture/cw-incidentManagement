package com.incture.im.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import java.text.ParseException;

import javax.persistence.Query;

import org.hibernate.Session;

import com.incture.im.dto.IncidentInfoDto;
import com.incture.im.entity.IncidentInfoDo;

public class IncidentInfoDao extends BaseDao {

	public IncidentInfoDo importIncidentInfo(IncidentInfoDto dto) throws ParseException {

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

		IncidentInfoDo dos = new IncidentInfoDo();

		dto.setIncidentId(SequenceNumberGen.getInstance().getNextSeqNumber("IN", 5, getSession()));

		dos.setIncidentId(dto.getIncidentId());

		dos.setIncidentLob(dto.getIncidentLob());
		dos.setIncidentType(dto.getIncidentType());
		dos.setIncidentDescription(dto.getIncidentDescription());
		dos.setIncidentPriority(dto.getIncidentPriority());
		dos.setIncidentAction(dto.getIncidentAction());
		dos.setCreatedDate(dateFormat.parse(dto.getCreatedDate()));
		dos.setFinishDate(dateFormat.parse(dto.getFinishDate()));
		dos.setIncidentStatus(dto.getIncidentStatus());
		dos.setReportedDate(dateFormat.parse(dto.getReportedDate()));
		dos.setAssignedGroup(dto.getAssignedGroup());
		dos.setAssignedTo(dto.getAssignedTo());
		dos.setAssignedDate(dateFormat.parse(dto.getAssignedDate()));

		return dos;

	}

	public IncidentInfoDto exportIncidentInfo(IncidentInfoDo dos) {

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

		IncidentInfoDto dto = new IncidentInfoDto();

		dto.setIncidentId(dos.getIncidentId());
		dto.setIncidentLob(dos.getIncidentLob());
		dto.setIncidentType(dos.getIncidentType());
		dto.setIncidentDescription(dos.getIncidentDescription());
		dto.setIncidentPriority(dos.getIncidentPriority());
		dto.setIncidentAction(dos.getIncidentAction());
		dto.setCreatedDate(dateFormat.format(dos.getCreatedDate()));
		dto.setFinishDate(dateFormat.format(dos.getFinishDate()));
		dto.setIncidentStatus(dos.getIncidentStatus());
		dto.setReportedDate(dateFormat.format(dos.getReportedDate()));
		dto.setAssignedGroup(dos.getAssignedGroup());
		dto.setAssignedTo(dos.getAssignedTo());
		dto.setAssignedDate(dateFormat.format(dos.getAssignedDate()));

		return dto;

	}

	public IncidentInfoDto getIncidentById(String id) {

		Session session = getSession();

		Query q = session.createQuery("from IncidentInfoDo where incidentId =:inid");
		q.setParameter("inid", id);

		@SuppressWarnings("rawtypes")
		IncidentInfoDo incidentDo = (IncidentInfoDo) ((org.hibernate.query.Query) q).uniqueResult();

		IncidentInfoDao incidentDao = new IncidentInfoDao();
		IncidentInfoDto incidentDto = new IncidentInfoDto();
		incidentDto = incidentDao.exportIncidentInfo(incidentDo);

		return incidentDto;

	}

	public List<IncidentInfoDto> getAllIncidents() {

		Session session = getSession();

		Query query = session.createQuery("from IncidentInfoDo");

		@SuppressWarnings({ "unchecked", "rawtypes" })
		List<IncidentInfoDo> incidentDoList = ((org.hibernate.query.Query) query).list();

		List<IncidentInfoDto> incidentDtoList = new ArrayList<IncidentInfoDto>();

		IncidentInfoDao incidentDao = new IncidentInfoDao();

		for (IncidentInfoDo incidentDo : incidentDoList) {

			IncidentInfoDto incidentDto = new IncidentInfoDto();

			incidentDto = incidentDao.exportIncidentInfo(incidentDo);

			incidentDtoList.add(incidentDto);

		}

		return incidentDtoList;

	}
}
