package com.main.TravU.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.main.TravU.dto.qna.Like_qnaDTO;
import com.main.TravU.service.qna.Like_qnaService;

@Controller
public class LIke_qnaController {
	private Like_qnaService service;
	@Autowired
	public LIke_qnaController(Like_qnaService service) {
		this.service = service;
	}
	
	//좋아요 
	@PostMapping("/board/view/QnA/Like.do")
	@ResponseBody
	public int likeUp(Like_qnaDTO lqdto) {
		return service.likeUp(lqdto);
	}
	
	//좋아요 취소
	@PostMapping("/board/view/QnA/LikeDown.do")
	@ResponseBody
	public int likeDown(Like_qnaDTO lqdto) {
		return service.likeDown(lqdto);
	}	
}
