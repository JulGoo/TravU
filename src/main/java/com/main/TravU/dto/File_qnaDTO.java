package com.main.TravU.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class File_qnaDTO {
	private int fileno;
	private int bbsno;
	private String path;
	private int size;
	private int available;
	
	@Builder
	public File_qnaDTO(String path, int size) {
		this.path = path;
		this.size = size;
	}
	
	public void setBbsno(int bbsno) {
		this.bbsno = bbsno; 
	}
}
