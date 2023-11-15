package com.main.TravU.dto.qna;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

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
	//첨부파일 List
	private List<MultipartFile> files = new ArrayList<>();
}
