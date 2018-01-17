package com.incture.im.services;

import com.incture.im.dao.UserInfoDao;
import com.incture.im.dto.UserInfoDto;

public class SearchUserServiceImp implements SearchUserService {
	
	
	@Override
	public UserInfoDto searchByUserId(String userid) {

		UserInfoDao searchById = new UserInfoDao();
		return searchById.getUserById(userid);
	}

}
