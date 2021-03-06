package com.incture.im.entity;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="IM_ROLEINFO")
public class RoleInfoDo implements BaseDo{
	
	
	@Id
	@Column(name="ROLE_ID", length=10,nullable=false)
	private String roleId;
	
	
	@Column(name="ROLE_NAME", length=50)
	private String roleName;
	
	@ManyToMany(mappedBy="roles")
	@JsonIgnore
	
	private List<UserInfoDo> roleusers = new ArrayList<UserInfoDo>();


	public String getRoleId() {
		return roleId;
	}


	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}


	public String getRoleName() {
		return roleName;
	}


	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}


	public List<UserInfoDo> getRoleusers() {
		return roleusers;
	}


	public void setRoleusers(List<UserInfoDo> roleusers) {
		this.roleusers = roleusers;
	}
	
	
}
