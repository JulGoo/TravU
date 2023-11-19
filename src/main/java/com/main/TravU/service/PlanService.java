package com.main.TravU.service;

import com.main.TravU.dto.PlanCardDTO;
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
}
