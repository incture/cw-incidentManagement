package com.incture.im.dao;

import com.incture.im.dto.UserInfoDto;
import com.incture.im.entity.UserInfo;

public class UserInfoDao {
	
	
	public UserInfo importUserInfo(UserInfoDto dto){
		
		UserInfo dos = new UserInfo();
		dos.setUserId(dto.getUserId());
		dos.setFirstName(dto.getFirstName());
		dos.setLastName(dto.getLastName());
		dos.setUserMobile(dto.getUserMobile());
		dos.setUserEmail(dto.getUserEmail());
		dos.setUserCostctr(dto.getUserCostctr());
		dos.setUserGroup(dto.getUserGroup());
		
		
		return dos;
		
	}
	
	public UserInfoDto exportUserInfo(UserInfo dos){
		
		UserInfoDto dto = new UserInfoDto();
		
		dto.setUserId(dos.getUserId());
		dto.setFirstName(dos.getFirstName());
		dto.setLastName(dos.getLastName());
		dto.setUserMobile(dos.getUserMobile());
		dto.setUserEmail(dos.getUserEmail());
		dto.setUserCostctr(dos.getUserCostctr());
		dto.setUserGroup(dos.getUserGroup());
		
		return dto;
		
		
	}
	
	

}
