package com.main.TravU.controller;

import com.main.TravU.dto.PlanCardDTO;
import com.main.TravU.service.PlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

import java.util.ArrayList;

@Controller    //어노테이션으로 너가 컨트롤러란다 해주기
@RequiredArgsConstructor
public class MainController {

    private final PlanService service;

    // Get/Post방식으로 Mapping (Post: 폼 태그 사용 ex.회원가입)
    @GetMapping("/")    //"localhost:8080/"
    public String index(HttpSession session, Model model) {
        String id = (String) session.getAttribute("userID");

        if (id == null) {
            ArrayList<PlanCardDTO> planCardDTO = new ArrayList<>();
            PlanCardDTO planCard = new PlanCardDTO();
            planCard.setPlanNo(0);
            planCard.setLat(0.0);
            planCard.setLng(0.0);
            planCard.setPlanName("Empty Plan");

            planCardDTO.add(planCard);
            model.addAttribute("planCardDTO", planCardDTO);
        } else {
            ArrayList<PlanCardDTO> planCardDTO = service.getPlanCardList(id);
            if (planCardDTO == null || planCardDTO.isEmpty()) {
                ArrayList<PlanCardDTO> planCardDTO2 = new ArrayList<>();
                PlanCardDTO planCard = new PlanCardDTO();
                planCard.setPlanNo(0);
                planCard.setLat(0.0);
                planCard.setLng(0.0);
                planCard.setPlanName("Empty Plan");

                planCardDTO2.add(planCard);
                model.addAttribute("planCardDTO", planCardDTO2);
            } else {
                model.addAttribute("planCardDTO", planCardDTO);
            }
        }
        return "index";
    }
}
