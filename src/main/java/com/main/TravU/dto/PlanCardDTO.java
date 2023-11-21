package com.main.TravU.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class PlanCardDTO {
    private int planNo;
    private String planName;
    private String userID;
    private Date startDate;
    private Date endDate;
    private String imgName;
}
