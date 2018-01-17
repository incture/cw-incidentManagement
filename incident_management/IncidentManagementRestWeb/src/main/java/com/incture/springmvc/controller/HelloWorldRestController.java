package com.incture.springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.incture.im.dto.IncidentApprovalDto;
import com.incture.im.dto.IncidentCreationDto;
import com.incture.im.dto.IncidentInfoDto;
import com.incture.im.dto.IncidentTableInfoDto;
import com.incture.im.dto.ResponseDto;
import com.incture.im.dto.SearchIncidentDto;
import com.incture.im.dto.UserInfoDto;
import com.incture.im.services.ApproveIncidentService;
import com.incture.im.services.ApproveIncidentServiceImp;
import com.incture.im.services.CreateIncidentService;
import com.incture.im.services.CreateIncidentServiceImp;
import com.incture.im.services.SearchIncidentService;
import com.incture.im.services.SearchIncidentServiceImp;
import com.incture.im.services.SearchUserService;
import com.incture.im.services.SearchUserServiceImp;
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

	public ResponseDto createIncicent(@RequestBody IncidentCreationDto createIncidentDto) {

		CreateIncidentService createIncidentService = new CreateIncidentServiceImp();

		return createIncidentService.createIncident(createIncidentDto);

	}

	@RequestMapping("/getuser/{id}")
	public UserInfoDto getUserInfo(@PathVariable String id) {

		SearchUserService searchUserService = new SearchUserServiceImp();

		return searchUserService.searchByUserId(id);

	}

	@RequestMapping(value = "/search", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@ResponseBody
	public List<IncidentTableInfoDto> searchIncident(@RequestBody SearchIncidentDto search) {

		SearchIncidentService searchIncidentService = new SearchIncidentServiceImp();

		List<IncidentTableInfoDto> incidents = new ArrayList<IncidentTableInfoDto>();

		incidents = searchIncidentService.getIncidentTableInfo(search);

		return incidents;

	}

	@RequestMapping("/getincident/{id}")
	public IncidentInfoDto getByIncidentId(@PathVariable String id) {

		SearchIncidentService searchByIdService = new SearchIncidentServiceImp();

		return searchByIdService.getIncidentById(id);

	}

	@RequestMapping("/getapproval/{id}")
	public IncidentApprovalDto getIncidentApproval(@PathVariable String id) {

		ApproveIncidentService approveIncidentService = new ApproveIncidentServiceImp();

		return approveIncidentService.searchApprovalIncident(id);

	}

	@RequestMapping("/allincidents")
	public List<IncidentInfoDto> getAllIncidents() {

		ApproveIncidentService incidentList = new ApproveIncidentServiceImp();

		return incidentList.getAllIncidents();
	}

}