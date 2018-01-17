package com.incture.im.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import com.incture.im.dto.IncidentTableInfoDto;
import com.incture.im.dto.SearchIncidentDto;
import com.incture.im.entity.IncidentInfoDo;

public class IncidentTableInfoDao extends BaseDao {

	public List<IncidentTableInfoDto> searchIncidentTableInfo(SearchIncidentDto searchIncidentTable) {

		Session session = getSession();

		String lineOfBusiness = searchIncidentTable.getLineOfBusiness();
		String priority = searchIncidentTable.getPriority();
		String stat = searchIncidentTable.getStatus();

		int count1 = 0, count2 = 0, count3 = 0;

		String queryString = "select incident from IncidentInfoDo incident where incident.incidentId IS NOT NULL ";

		if (lineOfBusiness != null && lineOfBusiness != "") {
			queryString += " and incident.incidentLob =:lob";

			++count1;

		}

		if (priority != null && priority != "") {
			queryString += " and incident.incidentPriority =:prio";

			++count2;

		}

		if (stat != null && stat != "") {
			queryString += " and incident.incidentStatus =:status";

			++count3;
		}

		Query query = session.createQuery(queryString);

		if (count1 != 0)
			query.setParameter("lob", lineOfBusiness);
		if (count2 != 0)
			query.setParameter("prio", priority);
		if (count3 != 0)
			query.setParameter("status", stat);

		@SuppressWarnings({ "unchecked", "rawtypes" })
		List<IncidentInfoDo> incidentInfoList = ((org.hibernate.query.Query) query).list();
		List<IncidentTableInfoDto> incidentInfoDto = new ArrayList<IncidentTableInfoDto>();

		for (IncidentInfoDo in : incidentInfoList) {

			IncidentTableInfoDto inDto = new IncidentTableInfoDto();
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		

			inDto.setIncidentId(in.getIncidentId());
			inDto.setIncidentLob(in.getIncidentLob());
			inDto.setIncidentPriority(in.getIncidentPriority());
			inDto.setIncidentStatus(in.getIncidentStatus());
			inDto.setCreatedDate(dateFormat.format(in.getCreatedDate()));
			inDto.setFinishDate(dateFormat.format(in.getFinishDate()));

			incidentInfoDto.add(inDto);

		}

		return incidentInfoDto;

	}

}
