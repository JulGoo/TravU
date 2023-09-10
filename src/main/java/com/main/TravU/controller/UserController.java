package com.main.TravU.controller;

import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.main.TravU.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	
	private UserService service;
	
	@Autowired
	public UserController(UserService service) {
		this.service = service;
	}
	
	//로그인
	@GetMapping("login.do")
	public String login(HttpSession session) {
		String id = (String) session.getAttribute("userID");
		if (id == null) {
			return "login";
		}else {		//이미 로그인되어있을 때
			return "index";
		}
	}
	
	@PostMapping("login.do")
	public String login1(String userID, String userPW, HttpSession session) {
		boolean TF = service.getuserPW(userID, userPW);
		if(TF) {
			session.setAttribute("userID", userID);
			return "index";
		} else {
			return "login";
		}
	}

	
	//회원가입
	@GetMapping("register.do")
	public String register() {
		return "register";
	}
	
	@PostMapping("register.do")
	public String register1(String userID, String userPW, String userName, String userEmail, String userPhone, String userGender) {
		
		return "register";
	}
}
