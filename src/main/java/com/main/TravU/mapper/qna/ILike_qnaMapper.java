package com.main.TravU.mapper.qna;

import org.apache.ibatis.annotations.Mapper;

import com.main.TravU.dto.qna.Like_qnaDTO;

@Mapper
public interface ILike_qnaMapper {
	public void likeUp(Like_qnaDTO lqdto);
	public void likeDown(Like_qnaDTO lqdto);
	public int doubleCheck(Like_qnaDTO lqdto);
	public int likeC(int no);
}
