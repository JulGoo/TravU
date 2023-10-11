package com.main.TravU.dto.review;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class File_reviewDTO {
	private int fileno;
	private int bbsno;
	private String origin;
	private String save;
	private int size;
	private int available;
	
	@Builder
	public File_reviewDTO(String origin, String save, int size) {
		this.origin = origin;
		this.save = save;
		this.size = size;
	}
	
	public void setBbsno(int bbsno) {
		this.bbsno = bbsno; 
	}
}

