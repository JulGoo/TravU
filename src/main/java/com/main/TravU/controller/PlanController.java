package com.main.TravU.controller;

import com.main.TravU.dto.PlanCardDTO;
import com.main.TravU.service.PlanService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("/travel")
@RequiredArgsConstructor
public class PlanController {
    private final PlanService service;
    
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


}
