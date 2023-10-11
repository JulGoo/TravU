package com.main.TravU.service.qna;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.TravU.dto.qna.Like_qnaDTO;
import com.main.TravU.mapper.qna.ILike_qnaMapper;

@Service
public class Like_qnaService {
	private ILike_qnaMapper mapper;

	@Autowired
	public Like_qnaService(ILike_qnaMapper mapper) {
		this.mapper = mapper;
	}

	//좋아요 등록
	public int likeUp(Like_qnaDTO lqdto) {
		int dc = doubleCheck(lqdto);
		if(dc == 1) {
			return -1;
		}else {
			mapper.likeUp(lqdto);;
			return likeC(lqdto.getNo());
		}
	}
	
	//좋아요 취소
	public int likeDown(Like_qnaDTO lqdto) {
		mapper.likeDown(lqdto);
		return likeC(lqdto.getNo());
	}

	// 좋아요 중복 체크
	public int doubleCheck(Like_qnaDTO lqdto) {
		return mapper.doubleCheck(lqdto);
	}
	
	//좋아요 개수 체크
	public int likeC(int no) {
		return mapper.likeC(no);
	}
	
}
