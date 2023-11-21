package com.main.TravU.controller;

import com.main.TravU.config.File_qnaUtils;
import com.main.TravU.dto.PlanCardDTO;
import com.main.TravU.dto.qna.File_qnaDTO;
import com.main.TravU.service.PlanService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/travel")
@RequiredArgsConstructor
public class PlanController {
    private final PlanService service;
    private final File_qnaUtils futils;
    
    //여행 계획 목록 보기
    @GetMapping("/plan/list.do")
    public String planList(Model model, HttpSession session){
        String userID = (String) session.getAttribute("userID");
        if (userID == null){
            model.addAttribute("msg", "로그인 후 이용해주세요.");
            model.addAttribute("url", "/login.do");
            return "alert";
        }

        ArrayList<PlanCardDTO> cards = service.getPlanCardList(userID);
        if (cards == null){
            System.out.println("nulllllll");
        }else {
            System.out.println("Hi:)");
            System.out.println(cards.get(0).getPlanName());
        }
        model.addAttribute("cards", cards);
        return "plan_card";
    }

    //여행 계획 보기
    @GetMapping("/plan_detail.do")
    public String planDetail() {return "plan_detail";}

    //여행 카드 저장
    @PostMapping("/plan_card/save.do")
    public String insertPlanCard(HttpSession session, PlanCardDTO planCardDTO, MultipartFile file){
        String userID = (String) session.getAttribute("userID");
        planCardDTO.setUserID(userID);
        planCardDTO.setImgName(futils.uploadProfileFile(file));

        //파일
//        if(!file.isEmpty()) {
//            // 파일 경로 및 확장자 처리
//            String realPath = Paths.get("C:", "Users", "yrrud", "OneDrive", "바탕 화면", "2-2", "SW", "TravU", "src", "main", "resources", "static", "profile_img").toString();
//            String fileName = StringUtils.cleanPath(file.getOriginalFilename()); // 파일 원본 이름
//            String fileExtension = StringUtils.getFilenameExtension(fileName);	 // 확장자
//            UUID uuid = UUID.randomUUID();							// 랜덤 UUID
//            String newFileName = uuid + "." + fileExtension;		// 저장할 파일 이름
//            File newFile = new File(realPath + "/" + newFileName);	// 저장할 파일 객체
//
//            // 파일 업로드
//            try {
//                file.transferTo(newFile);
//            } catch(Exception e) {
//                e.printStackTrace();
//            }
//
//            // 파일 경로 DTO에 저장
//            planCardDTO.setImgName(newFileName);
//        } else {
//            // 파일 미첨부 시
//            planCardDTO.setImgName("default.jpg");
//        }

        service.insertPlanCard(planCardDTO);

        return "redirect:/travel/plan/list.do";
    }
}
