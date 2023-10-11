package com.main.TravU.controller;

import java.net.http.HttpRequest;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.main.TravU.dto.qna.Bbs_qnaDTO;
import com.main.TravU.service.qna.Bbs_qnaService;
import com.main.TravU.service.qna.Like_qnaService;
import com.main.TravU.dto.qna.Like_qnaDTO;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/board")
public class Bbs_qnaController {

	private Bbs_qnaService service;
	private Like_qnaService lservice;

	@Autowired
	public Bbs_qnaController(Bbs_qnaService service, Like_qnaService lservice) {
		this.service = service;
		this.lservice = lservice;
	}

	// 질문 게시글 보기
	@GetMapping("/list/QnA.do")
	public ModelAndView bbs_qna() {
		ModelAndView mv = new ModelAndView();

		ArrayList<Bbs_qnaDTO> list = service.getList();

		mv.addObject("list", list);
		mv.setViewName("bbs_qna");

		return mv;
	}

	// 질문 게시글 입력 화면
	@GetMapping("/write/QnA.do")
	public String write_qna() {
		return "write_qna";
	}

	// 질문 게시글 업로드
	@PostMapping("/save/QnA.do")
	public String save_qna(HttpSession session, Bbs_qnaDTO bqdto) {
		String id = (String) session.getAttribute("userID");
		bqdto.setUserID(id);
		service.insertBbs(bqdto);
		return "redirect:/board/list/QnA.do";
	}

	// 상세 게시글 보기
	@GetMapping("/view/QnA.do")
	public ModelAndView view_qna(HttpSession session, int no) {
		ModelAndView mv = new ModelAndView();

		Bbs_qnaDTO bqdto = new Bbs_qnaDTO();
		bqdto = service.viewBbs(no);
		Like_qnaDTO lqdto = new Like_qnaDTO();
		lqdto.setNo(bqdto.getNo());
		lqdto.setUserID((String) session.getAttribute("userID"));

		boolean check = (lservice.doubleCheck(lqdto) == 1) ? true : false;

		mv.addObject("bqdto", bqdto);
		mv.addObject("check", check);
		mv.setViewName("view_qna");
		return mv;
	}

	//게시글 수정하기	
	@GetMapping("/update/QnA.do")
	public String updates(int no, Model m) {
		Bbs_qnaDTO bqdto = service.viewBbs(no);
		m.addAttribute("bqdto", bqdto);
		return "update_qna";
	}
	
	@PostMapping("/update/QnA.do")
	public String update(Bbs_qnaDTO bqdto, RedirectAttributes redirect) {
		service.update(bqdto);
		redirect.addAttribute("no", bqdto.getNo());
		return "redirect:/board/view/QnA.do";
	}
	
	// 게시글 삭제하기
	@PostMapping("/delete/QnA.do")
	public String delete(int no) {
		service.delete(no);
		return "redirect:/board/list/QnA.do";
	}

}
