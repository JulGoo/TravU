package com.main.TravU.service.qna;

import com.main.TravU.dto.qna.File_qnaDTO;
import com.main.TravU.mapper.qna.IFile_qnaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class File_qnaService {
    private final IFile_qnaMapper mapper;

    @Transactional
    public void saveFiles(final int bbsno, final List<File_qnaDTO> files) {
        if(CollectionUtils.isEmpty(files)){
            return;
        }
        for (File_qnaDTO file:files){
            file.setBbsno(bbsno);
        }
        mapper.saveAll(files);
    }

    public List<File_qnaDTO> fileBybbsno(final int bbsno){
        return mapper.fileBybbsno(bbsno);
    }

    public List<File_qnaDTO> fileByfileno(final List<Integer> fileno){
        if (CollectionUtils.isEmpty(fileno)){
            return Collections.emptyList();
        }
        return mapper.fileByfileno(fileno);
    }

    @Transactional
    public void deleteFile(final List<Integer> fileno){
        if(CollectionUtils.isEmpty(fileno)){
            return;
        }
        mapper.deleteFile(fileno);
    }
}
