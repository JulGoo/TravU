package com.main.TravU.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.main.TravU.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	private UserService service;

	@Autowired
	public UserController(UserService service) {
		this.service = service;
	}

	// 로그인
	@GetMapping("login.do")
	public String login(HttpSession session, HttpServletRequest request) {
		String id = (String) session.getAttribute("userID");
		if (id == null) {
			return "login";
		} else { // 이미 로그인되어있을 때
			request.setAttribute("msg", "이미 로그인 중입니다.");
			request.setAttribute("url", "/");
			return "alert";
		}
	}

	@PostMapping("login.do")
	public String login1(String userID, String userPW, HttpSession session, HttpServletRequest request) {
		int login_yn = service.getuserPW(userID, userPW);
		if (login_yn == 0) {
			request.setAttribute("msg", "아이디가 존재하지 않습니다.");
			request.setAttribute("url", "login.do");
			return "alert";
			//request.setAttribute("msg", 0);
		} else if (login_yn == 1) {
			request.setAttribute("msg", "아이디와 비밀번호가 일치하지 않습니다.");
			request.setAttribute("url", "login.do");
			return "alert";
			//request.setAttribute("msg", 1);
		} else if (login_yn == 2) {
			session.setAttribute("userID", userID);
//			request.setAttribute("msg", "로그인되었습니다.");
//			request.setAttribute("url", "/");
//			return "alert";
			//request.setAttribute("msg", 2);
			return "index";
		} else {
			request.setAttribute("msg", "database error.");
			request.setAttribute("url", "login.do");
			return "alert";
			//request.setAttribute("msg", 3);
		}
		//return "login";
	}

	// 로그아웃
	@GetMapping("logout.do")
	public String logout(HttpSession session, HttpServletRequest request) {
		request.setAttribute("msg", "로그아웃되었습니니다.");
		request.setAttribute("url", "/");
		session.invalidate();
		return "alert";
	}

	// 회원가입
	@GetMapping("register.do")
	public String register() {
		return "register";
	}

	@PostMapping("register.do")
	public String register1(String userID, String userPW, String userName, String userEmail, String userPhone,
			String userGender) {

		return "register";
	}
}
