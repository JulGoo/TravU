package com.main.TravU.mapper.qna;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.main.TravU.dto.qna.Bbs_qnaDTO;

@Mapper
public interface IBbs_qnaMapper {
	public int insertBbs(Bbs_qnaDTO bqdto);
	public ArrayList<Bbs_qnaDTO> getList();
	public Bbs_qnaDTO viewBbs(int no);
	public void viewC(int no);
	public void update(Bbs_qnaDTO bqdto);
	public void delete(int no);

	public int getNo(String userID);
}
