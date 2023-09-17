package com.main.TravU.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bbs_qnaDTO {
	private int no;
	private String title;
	private String userID;
	private String date;
	private int likeC;
	private int viewC;
	private int available;
}
