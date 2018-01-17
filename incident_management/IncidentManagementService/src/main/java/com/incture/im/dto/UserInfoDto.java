package com.incture.im.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import com.incture.im.entity.GroupInfoDo;


@XmlRootElement
public class UserInfoDto extends BaseDto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3064607488600390579L;
	private String userId;
	private String firstName;
	private String lastName;
	private String userMobile;
	private String userEmail;
	private String userCostctr;
	private String userGroup;
	private GroupInfoDo group;
	
	public GroupInfoDo getGroup() {
		return group;
	}
	public void setGroup(GroupInfoDo group) {
		this.group = group;
	}
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
	

}
