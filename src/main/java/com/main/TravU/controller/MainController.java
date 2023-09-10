package com.main.TravU.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller	//어노테이션으로 너가 컨트롤러란다 해주기
public class MainController {
	//Get/Post방식으로 Mapping (Post: 폼 태그 사용 ex.회원가입)
	@GetMapping("/")	//"localhost:8080/"
	public String index(HttpSession session) {
		
		return "index";
	}
}
