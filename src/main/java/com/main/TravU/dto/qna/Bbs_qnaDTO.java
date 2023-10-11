package com.main.TravU.dto.qna;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bbs_qnaDTO {
	private int no;
	private String title;
	private String userID;
	private String date;
	private int viewC;
	private int available;
	private String content;
	private int likeC;		//실제 디비에는 없지만 좋아요수를 가져올 때 SELECT로 COUNT(B.userID)를 가져오기 때문에 DTO에 지정
}
