package com.main.TravU.service.qna;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.TravU.dto.qna.Bbs_qnaDTO;
import com.main.TravU.mapper.qna.IBbs_qnaMapper;

@Service
public class Bbs_qnaService {
	
	private IBbs_qnaMapper mapper;
	
	@Autowired
	public Bbs_qnaService(IBbs_qnaMapper mapper) {
		this.mapper = mapper;
	}
	
	//게시글 입력
	public void insertBbs(Bbs_qnaDTO bqdto) {
		mapper.insertBbs(bqdto);
	}
	
	//게시글 목록 불러오기
	public ArrayList<Bbs_qnaDTO> getList(){
		return mapper.getList();
	}

	//상세 게시글 보기 
	public Bbs_qnaDTO viewBbs(int no) {
		Bbs_qnaDTO bqdto = mapper.viewBbs(no);
		//조회수 카운팅
		mapper.viewC(no);
		return bqdto;
	}
	
	//게시글 수정
	public void update(Bbs_qnaDTO bqdto) {
		mapper.update(bqdto);
	}
	
	//게시글 삭제
	public void delete(int no) {
		mapper.delete(no);
	}
}
