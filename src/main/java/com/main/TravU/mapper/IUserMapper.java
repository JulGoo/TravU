package com.main.TravU.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IUserMapper {
	public String getuserPW(String userID);
}
