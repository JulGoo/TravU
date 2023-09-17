package com.main.TravU.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BbsController {
	@GetMapping("QnA.do")
	public String bbs_qna() {
		return "bbs_qna";
	}
	
	//글쓰기
	@GetMapping("write_QnA.do")
	public String write_qna() {
		return "write_qna";
	}

}
