package com.incture.springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.incture.im.dto.ApprovalMasterDto;
import com.incture.im.dto.CreationMasterDto;
import com.incture.im.dto.IncidentInfoDto;
import com.incture.im.dto.IncidentTableMasterDto;
import com.incture.im.dto.SearchIncidentMasterDto;
import com.incture.im.dto.UserInfoDto;
import com.incture.im.services.IncidentManagementService;
import com.incture.im.services.IncidentManagementServiceImp;
import com.incture.springmvc.domain.Message;

@RestController
public class HelloWorldRestController {

	@RequestMapping("/")
	public String welcome() {// Welcome page, non-rest
		return "Welcome to RestTemplate Example.";
	}

	@RequestMapping("/hello/{player}")
	public Message message(@PathVariable String player) {// REST Endpoint.

		Message msg = new Message(player, "Hello " + player);
		return msg;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = { "application/JSON" })

	public String create(@RequestBody CreationMasterDto create) {

		IncidentManagementService s1 = new IncidentManagementServiceImp();

		return s1.createRecord(create);

	}

	@RequestMapping("/get/{id}")
	public UserInfoDto getRec(@PathVariable String id) {

		IncidentManagementService s2 = new IncidentManagementServiceImp();
		UserInfoDto usr;

		usr = s2.getUserById(id);

		return usr;

	}

	@RequestMapping(value = "/search", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@ResponseBody
	public List<IncidentTableMasterDto> getIncident(@RequestBody SearchIncidentMasterDto search) {

		IncidentManagementService s3 = new IncidentManagementServiceImp();

		List<IncidentTableMasterDto> incidents = new ArrayList<IncidentTableMasterDto>();

		incidents = s3.getIncidentTableInfo(search);

		return incidents;

	}

	@RequestMapping("/getincident/{id}")
	public IncidentInfoDto getByIncidentId(@PathVariable String id) {

		IncidentManagementService s4 = new IncidentManagementServiceImp();
		IncidentInfoDto inid = new IncidentInfoDto();

		inid = s4.getIncidentById(id);

		return inid;

	}

	@RequestMapping("/test")

	public SearchIncidentMasterDto getUITestSample() {

		IncidentManagementServiceImp a5 = new IncidentManagementServiceImp();

		return a5.testreturnDto();
	}

	@RequestMapping("/getapproval/{id}")
	public ApprovalMasterDto getApprovalDetails(@PathVariable String id) {

		IncidentManagementService s6 = new IncidentManagementServiceImp();
		ApprovalMasterDto approve = new ApprovalMasterDto();
		;

		approve = s6.searchApprovalIncident(id);

		return approve;

	}

	@RequestMapping("/allincidents")
	public List<IncidentInfoDto> getIncidents()
	{

		IncidentManagementService s7 = new IncidentManagementServiceImp();
		List<IncidentInfoDto> incidentList = new ArrayList<IncidentInfoDto>();
		incidentList = s7.getAllIncidents();
		return incidentList;
	}

}
