package com.incture.im.dao;

import com.incture.im.dto.GroupInfoDto;
import com.incture.im.entity.GroupInfoDo;

public class GroupInfoDao  {
	
	public GroupInfoDo importGroupInfo(GroupInfoDto dto){
		
		GroupInfoDo dos = new GroupInfoDo();
		
		dos.setGroupId(dto.getGroupId());
		dos.setGroupName(dto.getGroupName());
		
		return dos;
	}
	
	public GroupInfoDto exportGroupInfo(GroupInfoDo dos){
		
		GroupInfoDto dto = new GroupInfoDto();
		
		dto.setGroupId(dos.getGroupId());
		dto.setGroupName(dos.getGroupName());
		
		return dto;
	}

}
