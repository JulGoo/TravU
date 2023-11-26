package com.main.TravU.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Time;

@Getter
@Setter
public class PlanDetailDTO {
    private int seq;
    private int planNo;
    private int day;
    private String place;
    private String title;
    private String content;
    private Time startTime;
    private Time endTime;
}
