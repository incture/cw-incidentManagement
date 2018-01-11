package com.incture.im.dao;

import com.incture.im.dto.GroupInfoDto;
import com.incture.im.entity.GroupInfo;

public class GroupInfoDao {
	
	public GroupInfo importGroupInfo(GroupInfoDto dto){
		
		GroupInfo dos = new GroupInfo();
		
		dos.setGroupId(dto.getGroupId());
		dos.setGroupName(dto.getGroupName());
		
		return dos;
	}
	
	public GroupInfoDto exportGroupInfo(GroupInfo dos){
		
		GroupInfoDto dto = new GroupInfoDto();
		
		dto.setGroupId(dos.getGroupId());
		dto.setGroupName(dos.getGroupName());
		
		return dto;
	}

}
