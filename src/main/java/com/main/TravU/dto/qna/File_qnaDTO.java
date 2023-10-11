package com.main.TravU.dto.qna;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class File_qnaDTO {
	private int fileno;
	private int bbsno;
	private String origin;
	private String save;
	private int size;
	private int available;
	
	@Builder
	public File_qnaDTO(String origin, String save, int size) {
		this.origin = origin;
		this.save = save;
		this.size = size;
	}
	
	public void setBbsno(int bbsno) {
		this.bbsno = bbsno; 
	}
}
