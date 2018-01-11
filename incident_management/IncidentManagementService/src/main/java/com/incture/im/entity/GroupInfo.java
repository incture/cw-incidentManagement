package com.incture.im.entity;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="IM_GROUPINFO")
public class GroupInfo {
	
	@Id
	@Column(name="GROUP_ID", length=10)
	private String groupId;
	
	
	@Column(name="GROUP_NAME", length=50)
	private String groupName;
	
	@OneToMany(mappedBy = "group")
	@JsonIgnore

	private List<UserInfo> user = new ArrayList<UserInfo>();


	public String getGroupId() {
		return groupId;
	}


	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}


	public String getGroupName() {
		return groupName;
	}


	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}


	public List<UserInfo> getUser() {
		return user;
	}


	public void setUser(List<UserInfo> user) {
		this.user = user;
	}
	
	
	
}
