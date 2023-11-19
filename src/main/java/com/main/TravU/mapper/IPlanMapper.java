package com.main.TravU.mapper;

import com.main.TravU.dto.PlanCardDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface IPlanMapper {
    public void insertPlanCard(PlanCardDTO planCardDTO);
    public ArrayList<PlanCardDTO> getPlanCardList(String userID);
}
