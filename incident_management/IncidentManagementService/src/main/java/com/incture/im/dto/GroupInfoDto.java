package com.incture.im.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement

public class GroupInfoDto implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1578406726069085127L;
	
	private String groupId;
	private String groupName;
	
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
