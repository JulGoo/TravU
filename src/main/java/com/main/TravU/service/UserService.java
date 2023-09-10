package com.main.TravU.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.TravU.mapper.IUserMapper;

@Service
public class UserService {
	
	private IUserMapper mapper;
	
	@Autowired
	public UserService(IUserMapper mapper) {
		this.mapper = mapper;
	}
	
	public boolean getuserPW(String userID, String userPW) {
		String pw = mapper.getuserPW(userID);
		if (pw.equals(userPW)) {
			return true;
		} else {
			return false;
		}
	}
}
