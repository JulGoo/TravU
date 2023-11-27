package com.main.TravU.controller;

import com.main.TravU.config.File_qnaUtils;
import com.main.TravU.dto.PlanCardDTO;
import com.main.TravU.dto.PlanDetailDTO;
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
//        if (cards == null){
//            System.out.println("nulllllll");
//        }else {
//            System.out.println("Hi:)");
//            System.out.println(cards.get(0).getPlanName());
//        }
        model.addAttribute("cards", cards);
        return "plan_card";
    }

    //여행 카드 저장
    @PostMapping("/plan_card/save.do")
    public String insertPlanCard(HttpSession session, PlanCardDTO planCardDTO, MultipartFile file){

        System.out.println(planCardDTO.toString());

        String userID = (String) session.getAttribute("userID");
        planCardDTO.setUserID(userID);
        planCardDTO.setImgName(futils.uploadPlanCardImg(file));
        service.insertPlanCard(planCardDTO);

        return "redirect:/travel/plan/list.do";
    }

    //세부 여행 계획 만들기
    @GetMapping("/plan/make.do")
    public String makePlan(Model model, Integer planNo){
        PlanCardDTO planCardDTO = service.getPlanCard(planNo);
        model.addAttribute("planCardDTO", planCardDTO);

        return "plan_make";
    }

    //세부 여행 계획 저장
    @PostMapping("/plan/save.do")
    public String savePlan(PlanDetailDTO planDetailDTO, Integer planNo){
        planDetailDTO.setPlanNo(planNo);
        service.insertPlan(planDetailDTO);

        return "redirect:/travel/plan/view.do";
    }

    //여행 계획 보기
    @GetMapping("/plan/view.do")
    public String planDetail(Model model, Integer planNo) {
        PlanCardDTO planCardDTO = service.getPlanCard(planNo);
        model.addAttribute("planCardDTO", planCardDTO);

        PlanDetailDTO plan = service.getPlan(planNo);
        model.addAttribute("plan", plan);

        return "plan_detail";
    }
}
