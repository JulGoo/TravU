package com.main.TravU.service;

import com.main.TravU.dto.PlanCardDTO;
import com.main.TravU.dto.PlanDetailDTO;
import com.main.TravU.mapper.IPlanMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class PlanService {
    private final IPlanMapper mapper;

    //여행 계획 카드 만들기
    public void insertPlanCard(PlanCardDTO planCardDTO){
        mapper.insertPlanCard(planCardDTO);
    }

    //여행 계획 카드 목록 보기
    public ArrayList<PlanCardDTO> getPlanCardList(String userID) {
        return mapper.getPlanCardList(userID);
    }

    //여행 카드 정보 가져오기
    public PlanCardDTO getPlanCard(int planNo) {
        return mapper.getPlanCard(planNo);
    }

    //세부 여행 계획 만들기
    public void insertPlan(PlanDetailDTO planDetailDTO){
        mapper.insertPlan(planDetailDTO);
    }

    //세부 여행 계획 보기
    public PlanDetailDTO getPlan(int planNo) {
        return mapper.getPlan(planNo);
    }
}
