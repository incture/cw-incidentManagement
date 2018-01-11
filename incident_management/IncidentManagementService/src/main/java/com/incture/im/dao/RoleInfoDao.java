package com.incture.im.dao;


import com.incture.im.dto.RoleInfoDto;
import com.incture.im.entity.RoleInfo;

public class RoleInfoDao {
	
public RoleInfo importRoleInfo(RoleInfoDto dto){
		
		RoleInfo dos = new RoleInfo();
		
		dos.setRoleId(dto.getRoleId());
		dos.setRoleName(dto.getRoleName());
		
		return dos;
	}
	
	public RoleInfoDto exportRoleInfo(RoleInfo dos){
		
		RoleInfoDto dto = new RoleInfoDto();
		
		dto.setRoleId(dos.getRoleId());
		dto.setRoleName(dos.getRoleName());
		
		return dto;
	}
	
	
	

}
