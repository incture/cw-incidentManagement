package com.incture.im.services;

import com.incture.im.dto.UserInfoDto;

public interface SearchUserService {

	UserInfoDto searchByUserId(String userid);

}
