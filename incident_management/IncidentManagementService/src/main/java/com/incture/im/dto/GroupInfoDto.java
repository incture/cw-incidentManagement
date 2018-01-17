package com.incture.im.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.incture.im.entity.UserInfoDo;

@XmlRootElement

public class GroupInfoDto extends BaseDto implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1578406726069085127L;
	
	private String groupId;
	private String groupName;
	private List<UserInfoDo> user = new ArrayList<UserInfoDo>();
	
	public List<UserInfoDo> getUser() {
		return user;
	}
	public void setUser(List<UserInfoDo> user) {
		this.user = user;
	}
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
	
	
	
	
}
