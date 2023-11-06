package com.main.TravU.mapper.qna;

import com.main.TravU.dto.qna.File_qnaDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IFile_qnaMapper {
    void saveAll(List<File_qnaDTO> files);

    //파일 조회 - 게시글 번호로
    List<File_qnaDTO> fileBybbsno(int bbsno);

    //파일 조회 - 파일 번호로
    List<File_qnaDTO> fileByfileno(List<Integer> fileno);

    //파일 삭제
    void deleteFile(List<Integer> fileno);
}
