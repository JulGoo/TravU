package com.main.TravU.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PlanController {
    @GetMapping("/travel_plan.do")
    public String planList(){
        return "travel_plan";
    }


}
