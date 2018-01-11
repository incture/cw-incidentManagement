package com.incture.im.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "IM_USERINFO")
public class UserInfo {

	@Id
	@Column(name = "USER_ID")
	private String userId;

	@Column(name = "FIRST_NAME", length = 50)
	private String firstName;

	@Column(name = "LAST_NAME", length = 50)
	private String lastName;

	@Column(name = "USER_MOBILE", length = 20)
	private String userMobile;

	@Column(name = "USER_EMAIL", length = 150)
	private String userEmail;

	@Column(name = "USER_COSTCTR", length = 50)
	private String userCostctr;

	@Column(name = "USER_GROUP", length = 50)
	private String userGroup;

	@ManyToOne
	private GroupInfo group;

	@ManyToMany(mappedBy = "users")
	@JsonIgnore

	private List<IncidentInfo> incidents = new ArrayList<IncidentInfo>();

	@ManyToMany
	private List<RoleInfo> roles = new ArrayList<RoleInfo>();

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserMobile() {
		return userMobile;
	}

	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserCostctr() {
		return userCostctr;
	}

	public void setUserCostctr(String userCostctr) {
		this.userCostctr = userCostctr;
	}

	public String getUserGroup() {
		return userGroup;
	}

	public void setUserGroup(String userGroup) {
		this.userGroup = userGroup;
	}

	public GroupInfo getGroup() {
		return group;
	}

	public void setGroup(GroupInfo group) {
		this.group = group;
	}

	public List<IncidentInfo> getIncidents() {
		return incidents;
	}

	public void setIncidents(List<IncidentInfo> incidents) {
		this.incidents = incidents;
	}

	public List<RoleInfo> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleInfo> roles) {
		this.roles = roles;
	}

}
