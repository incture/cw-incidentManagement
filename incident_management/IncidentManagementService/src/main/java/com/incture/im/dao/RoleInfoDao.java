package com.incture.im.dao;


import com.incture.im.dto.RoleInfoDto;
import com.incture.im.entity.RoleInfoDo;

public class RoleInfoDao  {
	
public RoleInfoDo importRoleInfo(RoleInfoDto dto){
		
		RoleInfoDo dos = new RoleInfoDo();
		
		dos.setRoleId(dto.getRoleId());
		dos.setRoleName(dto.getRoleName());
		
		return dos;
	}
	
	public RoleInfoDto exportRoleInfo(RoleInfoDo dos){
		
		RoleInfoDto dto = new RoleInfoDto();
		
		dto.setRoleId(dos.getRoleId());
		dto.setRoleName(dos.getRoleName());
		
		return dto;
	}

}
