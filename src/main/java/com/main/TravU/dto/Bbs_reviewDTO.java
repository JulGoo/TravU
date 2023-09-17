package com.main.TravU.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bbs_reviewDTO {
	private int no;
	private String title;
	private String destination;
	private String period;
	private String userID;
	private String date;
	private int likeC;
	private int viewC;
	private int available;
}
