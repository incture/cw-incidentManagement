package com.incture.im.dao;

import javax.persistence.Query;

import org.hibernate.Session;

import com.incture.im.dto.UserInfoDto;
import com.incture.im.entity.UserInfoDo;

public class UserInfoDao extends BaseDao {

	public UserInfoDo importUserInfo(UserInfoDto dto) {

		UserInfoDo dos = new UserInfoDo();
		dos.setUserId(dto.getUserId());
		dos.setFirstName(dto.getFirstName());
		dos.setLastName(dto.getLastName());
		dos.setUserMobile(dto.getUserMobile());
		dos.setUserEmail(dto.getUserEmail());
		dos.setUserCostctr(dto.getUserCostctr());
		dos.setUserGroup(dto.getUserGroup());

		return dos;

	}

	public UserInfoDto exportUserInfo(UserInfoDo dos) {

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

	public UserInfoDto getUserById(String userId) {

		Session session = getSession();

		Query query = session.createQuery("from UserInfoDo where userId =:uid");
		query.setParameter("uid", userId);

		@SuppressWarnings("rawtypes")
		UserInfoDo userDo = (UserInfoDo) ((org.hibernate.query.Query) query).uniqueResult();

		UserInfoDao userDao = new UserInfoDao();
		UserInfoDto userDto = new UserInfoDto();
		userDto = userDao.exportUserInfo(userDo);

		session.close();

		return userDto;

	}

}
