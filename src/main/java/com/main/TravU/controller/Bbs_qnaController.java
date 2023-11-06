package com.main.TravU.controller;

import java.util.ArrayList;
import java.util.List;

import com.main.TravU.config.File_qnaUtils;
import com.main.TravU.dto.qna.File_qnaDTO;
import com.main.TravU.service.qna.File_qnaService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.main.TravU.dto.qna.Bbs_qnaDTO;
import com.main.TravU.service.qna.Bbs_qnaService;
import com.main.TravU.service.qna.Like_qnaService;
import com.main.TravU.dto.qna.Like_qnaDTO;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/board")
@AllArgsConstructor
public class Bbs_qnaController {

	private final Bbs_qnaService bservice;
	private final Like_qnaService lservice;
	private final File_qnaService fservice;
	private final File_qnaUtils futils;

	// 질문 게시글 보기
	@GetMapping("/list/QnA.do")
	public ModelAndView bbs_qna() {
		ModelAndView mv = new ModelAndView();

		ArrayList<Bbs_qnaDTO> list = bservice.getList();

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
		int bbsno = bservice.insertBbs(bqdto);

		List<File_qnaDTO> files = futils.uploadFiles(bqdto.getFiles());
		fservice.saveFiles(bbsno, files);

		return "redirect:/board/list/QnA.do";
	}

	// 상세 게시글 보기
	@GetMapping("/view/QnA.do")
	public ModelAndView view_qna(HttpSession session, int no, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();

		Bbs_qnaDTO bqdto = new Bbs_qnaDTO();
		bqdto = bservice.viewBbs(no);
		Like_qnaDTO lqdto = new Like_qnaDTO();
		lqdto.setNo(bqdto.getNo());

		//
		List<File_qnaDTO> fqdto = new ArrayList<>();
		fqdto = fservice.fileBybbsno(no);
		//

		String id = (String) session.getAttribute("userID");
		lqdto.setUserID(id);

		if (id == null){
			request.setAttribute("msg", "로그인 후 이용해주세요.");
			request.setAttribute("url", "/board/list/QnA.do");
			mv.setViewName("alert");
			return mv;
		}

		boolean check = lservice.doubleCheck(lqdto) == 1;

		mv.addObject("bqdto", bqdto);
		mv.addObject("check", check);
		mv.addObject("fqdto", fqdto);
		mv.setViewName("view_qna");
		return mv;
	}

	//게시글 수정하기	
	@GetMapping("/update/QnA.do")
	public String updates(int no, Model m) {
		Bbs_qnaDTO bqdto = bservice.viewBbs(no);
		m.addAttribute("bqdto", bqdto);
		return "update_qna";
	}
	
	@PostMapping("/update/QnA.do")
	public String update(Bbs_qnaDTO bqdto, RedirectAttributes redirect) {
		bservice.update(bqdto);
		redirect.addAttribute("no", bqdto.getNo());
		return "redirect:/board/view/QnA.do";
	}
	
	// 게시글 삭제하기
	@PostMapping("/delete/QnA.do")
	public String delete(int no) {
		bservice.delete(no);
		return "redirect:/board/list/QnA.do";
	}

}
