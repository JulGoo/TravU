package com.main.TravU.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@Getter
@Setter
@ToString
public class PlanCardDTO {
    private int planNo;
    private String planName;
    private String userID;
    private Date startDate;
    private Date endDate;
    private String imgName;
    private Double lat;
    private Double lng;
}
