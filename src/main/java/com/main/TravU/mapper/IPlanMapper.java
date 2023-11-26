package com.main.TravU.mapper;

import com.main.TravU.dto.PlanCardDTO;
import com.main.TravU.dto.PlanDetailDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface IPlanMapper {
    public void insertPlanCard(PlanCardDTO planCardDTO);
    public ArrayList<PlanCardDTO> getPlanCardList(String userID);
    public PlanCardDTO getPlanCard(int planNo);
    public void insertPlan(PlanDetailDTO planDetailDTO);
    public PlanDetailDTO getPlan(int planNo);
}
