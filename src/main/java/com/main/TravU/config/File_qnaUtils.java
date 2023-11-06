package com.main.TravU.config;

import com.main.TravU.dto.qna.File_qnaDTO;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Component
public class File_qnaUtils {
    private final String uploadPath = Paths.get("C:", "Users", "yrrud", "OneDrive", "바탕 화면", "2-2", "SW", "upload_files").toString();

    //다중 파일 업로드
    public List<File_qnaDTO> uploadFiles(final List<MultipartFile> multipartFiles){
        List<File_qnaDTO> files = new ArrayList<>();
        for (MultipartFile multipartFile : multipartFiles){
            if(multipartFile.isEmpty()){
                continue;
            }
            files.add(uploadFile(multipartFile));
        }
        return files;
    }

    //단일 파일 업로드
    private File_qnaDTO uploadFile(final MultipartFile multipartFile) {
        if(multipartFile.isEmpty()){
            return null;
        }
        
        String saveName = SaveN(multipartFile.getOriginalFilename());
        String today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyMMdd")).toString();
        String uploadPath = getUploadPath(today) + File.separator + saveName;
        File uploadFile  = new File(uploadPath);

        try{
            multipartFile.transferTo(uploadFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return File_qnaDTO.builder()
                .origin(multipartFile.getOriginalFilename())
                .save(saveName)
                .size(multipartFile.getSize())
                .build();
    }
    //업로드 경로 반환
    private String getUploadPath() {
        return makeDir(uploadPath);
    }

    //업로드 경로 반환
    //추가 경로
    private String getUploadPath(final String addPath){
        return makeDir(uploadPath + File.separator + addPath);
    }

    //저장 파일명 생성
    private String SaveN(final String filename) {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        String extension = StringUtils.getFilenameExtension(filename);
        return uuid + "." + extension;
    }

    //업로드 폴더 생성
    private String makeDir(final String path) {
        File dir = new File(path);
        if(!dir.exists()){
            dir.mkdirs();
        }
        return dir.getPath();
    }
}
